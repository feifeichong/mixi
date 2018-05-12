package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Customer;
import com.lecotec.mixi.model.parameter.UserParamForChangePassword;
import com.lecotec.mixi.model.parameter.UserParamWithPassword;
import com.lecotec.mixi.model.parameter.UserParamWithShortMsgCode;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.lecotec.mixi.common.AuthorityUtil.produceCookieAndSession;
import static com.lecotec.mixi.common.ConstString.CUSTOMER_PHONE_NUMBER;
import static com.lecotec.mixi.common.ConstString.CUSTOMER_TOKEN;

@RestController
@RequestMapping("/api/customer")
@Api(value = "/api/customer", tags = "顾客登录、注册、忘记密码和修改密码接口集合")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/login/shortMsgCodeLogin")
    @ApiOperation("顾客登录接口（手机号、短信验证码），调用之前先获取RSA公钥，加密手机号和短信验证码")
    @ApiImplicitParams(@ApiImplicitParam(name = "userParamWithShortMsgCode", value = "手机号、短信验证码", required = true, dataType = "UserParamWithShortMsgCode"))
    public ResponseObject shortMsgCodeLogin(@Valid @RequestBody UserParamWithShortMsgCode userParamWithShortMsgCode, HttpServletResponse response, HttpSession session) throws Exception {
        /*Key privateKey = (Key) session.getAttribute(ConstString.RSA_PRIVATE_KEY);*/
        String phoneNumber = /*EncryptUtil.rsaDecrypt(*/userParamWithShortMsgCode.getPhoneNumber()/*, privateKey)*/;
        String shortMsgCode = /*EncryptUtil.rsaDecrypt(*/userParamWithShortMsgCode.getShortMsgCode()/*, privateKey)*/;

        Customer customer = customerService.findByPhoneNumber(phoneNumber);

        Object shortMsgCodeInServer = session.getAttribute(phoneNumber);

        if (ObjectUtils.isEmpty(customer) || !StringUtils.equals(shortMsgCode, shortMsgCodeInServer == null ? "" : shortMsgCodeInServer.toString())) {
            return new FailResponse("手机号或者短信验证码错误！");
        }

        produceCookieAndSession(response, session, userParamWithShortMsgCode, CUSTOMER_PHONE_NUMBER, CUSTOMER_TOKEN);

        return new SuccessResponse();
    }

    @PostMapping("/login/pwdLogin")
    @ApiOperation("顾客登录接口（手机号、密码），调用之前先获取RSA公钥，加密手机号和密码")
    @ApiImplicitParams(@ApiImplicitParam(name = "userParamWithPassword", value = "手机号、密码", required = true, dataType = "UserParamWithPassword"))
    public ResponseObject pwdLogin(@Valid @RequestBody UserParamWithPassword userParamWithPassword, HttpServletResponse response, HttpSession session) throws Exception {
        /*Key privateKey = (Key) session.getAttribute(ConstString.RSA_PRIVATE_KEY);*/
        String phoneNumber = /*EncryptUtil.rsaDecrypt(*/userParamWithPassword.getPhoneNumber()/*, privateKey)*/;
        String password = /*EncryptUtil.rsaDecrypt(*/userParamWithPassword.getPassword()/*, privateKey)*/;

        Customer customer = customerService.findByPhoneNumber(phoneNumber);

        if (ObjectUtils.isEmpty(customer) || !StringUtils.equals(password, customer.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        produceCookieAndSession(response, session, userParamWithPassword, CUSTOMER_PHONE_NUMBER, CUSTOMER_TOKEN);

        return new SuccessResponse();
    }

    @PostMapping
    @ApiOperation("顾客注册接口")
    @ApiImplicitParam(name = "customer", value = "用户上传顾客信息", required = true, dataType = "Customer")
    public ResponseObject saveCustomer(@Valid @RequestBody Customer customer) {
        return new SuccessResponse(customerService.saveCustomer(customer));
    }

    @PutMapping("/customerPassword")
    @ApiOperation("顾客修改密码接口")
    @ApiImplicitParam(name = "userParamForChangePassword", value = "顾客提交密码修改信息", required = true, dataType = "UserParamForChangePassword")
    public ResponseObject updateCustomerPassword(@Valid @RequestBody UserParamForChangePassword userParamForChangePassword) {
        String phoneNumber = /*EncryptUtil.rsaDecrypt(*/userParamForChangePassword.getPhoneNumber()/*, privateKey)*/;
        String password = /*EncryptUtil.rsaDecrypt(*/userParamForChangePassword.getPassword()/*, privateKey)*/;
        String newPassword = /*EncryptUtil.rsaDecrypt(*/userParamForChangePassword.getNewPassword()/*, privateKey)*/;

        Customer customer = customerService.findByPhoneNumber(phoneNumber);

        if (ObjectUtils.isEmpty(customer) || !StringUtils.equals(password, customer.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        return new SuccessResponse(customerService.updateCustomerPassword(phoneNumber, newPassword));
    }
}
