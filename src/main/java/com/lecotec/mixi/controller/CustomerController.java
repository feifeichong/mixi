package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.dto.CustomerVO;
import com.lecotec.mixi.model.entity.Customer;
import com.lecotec.mixi.model.parameter.CustomerSearchParam;
import com.lecotec.mixi.model.parameter.UserParamForChangePassword;
import com.lecotec.mixi.model.parameter.UserParamWithPassword;
import com.lecotec.mixi.model.parameter.UserParamWithShortMsgCode;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.CustomerService;
import com.lecotec.mixi.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.lecotec.mixi.common.AuthorityUtil.produceCookieAndSession;
import static com.lecotec.mixi.common.ConstString.CUSTOMER_PHONE_NUMBER;
import static com.lecotec.mixi.common.ConstString.CUSTOMER_TOKEN;

@RestController
@Api(tags = "顾客信息接口")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/api/customer/login/shortMsgCodeLogin")
    @ApiOperation("顾客登录接口（手机号、短信验证码）")
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

    @PostMapping("/api/customer/login/pwdLogin")
    @ApiOperation("顾客登录接口（手机号、密码）")
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

    @PostMapping("/api/customer")
    @ApiOperation("顾客注册接口")
    public ResponseObject saveOrUpdateCustomer(@Valid @RequestBody Customer customer) {
        return new SuccessResponse(customerService.saveOrUpdateCustomer(customer));
    }

    @PutMapping("/api/customer/changePassword")
    @ApiOperation("顾客修改密码接口")
    public ResponseObject updateCustomerPassword(@Valid @RequestBody UserParamForChangePassword userParamForChangePassword) {
        String phoneNumber = userParamForChangePassword.getPhoneNumber();
        String password = userParamForChangePassword.getPassword();
        String newPassword = userParamForChangePassword.getNewPassword();

        Customer customer = customerService.findByPhoneNumber(phoneNumber);

        if (ObjectUtils.isEmpty(customer) || !StringUtils.equals(password, customer.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        return new SuccessResponse(customerService.updateCustomerPassword(phoneNumber, newPassword));
    }

    @GetMapping("/api/merchant/customer/searchCustomerForMixiConsole")
    @ApiOperation("系统后台查询顾客信息接口")
    public BootstrapTableResult<CustomerVO> searchCustomerForMixiConsole(CustomerSearchParam customerSearchParam) {
        Page<Customer> result = customerService.searchCustomerForMixiConsole(customerSearchParam);
        List<CustomerVO> customerVOS = new ArrayList<>();
        for (Customer customer : result.getContent()) {
            CustomerVO vo = new CustomerVO();
            BeanUtils.copyProperties(customer, vo);
            vo.setOrders(orderService.getOrdersByCustomerId(customer.getId()));
            customerVOS.add(vo);
        }
        return new BootstrapTableResult<>(result.getTotalElements(), customerVOS);
    }

    @PutMapping("/api/merchant/customer/changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(customerService.changeActiveStatus(id, isActive));
    }
}
