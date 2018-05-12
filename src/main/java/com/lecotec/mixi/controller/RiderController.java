package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Rider;
import com.lecotec.mixi.model.parameter.UserParam;
import com.lecotec.mixi.model.parameter.UserParamForChangePassword;
import com.lecotec.mixi.model.parameter.UserParamWithPassword;
import com.lecotec.mixi.model.parameter.UserParamWithShortMsgCode;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.RiderService;
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
import static com.lecotec.mixi.common.ConstString.*;

@RestController
@RequestMapping("/api/rider")
@Api(value = "/api/rider", tags = "骑手登录、注册、忘记密码、修改密码和缴纳保证金接口集合")
public class RiderController {

    @Autowired
    private RiderService riderService;

    @PostMapping("/login/shortMsgCodeLogin")
    @ApiOperation("骑手登录接口（手机号、短信验证码），调用之前先获取RSA公钥，加密手机号和短信验证码")
    @ApiImplicitParams(@ApiImplicitParam(name = "userParamWithShortMsgCode", value = "手机号、短信验证码", required = true, dataType = "UserParamWithShortMsgCode"))
    public ResponseObject shortMsgCodeLogin(@Valid @RequestBody UserParamWithShortMsgCode userParamWithShortMsgCode, HttpServletResponse response, HttpSession session) throws Exception {
        /*Key privateKey = (Key) session.getAttribute(ConstString.RSA_PRIVATE_KEY);*/
        String phoneNumber = /*EncryptUtil.rsaDecrypt(*/userParamWithShortMsgCode.getPhoneNumber()/*, privateKey)*/;
        String shortMsgCode = /*EncryptUtil.rsaDecrypt(*/userParamWithShortMsgCode.getShortMsgCode()/*, privateKey)*/;

        Rider rider = riderService.findByPhoneNumber(phoneNumber);
        Object shortMsgCodeInServer = session.getAttribute(phoneNumber);

        if (ObjectUtils.isEmpty(rider) || !StringUtils.equals(shortMsgCode, shortMsgCodeInServer == null ? "" : shortMsgCodeInServer.toString())) {
            return new FailResponse("手机号或者短信验证码错误！");
        }

        produceCookieAndSession(response, session, userParamWithShortMsgCode, RIDER_PHONE_NUMBER, RIDER_TOKEN);

        return new SuccessResponse();
    }

    @PostMapping("/login/pwdLogin")
    @ApiOperation("骑手登录接口（手机号、密码），调用之前先获取RSA公钥，加密手机号和密码")
    @ApiImplicitParams(@ApiImplicitParam(name = "userParamWithPassword", value = "手机号、密码", required = true, dataType = "UserParamWithPassword"))
    public ResponseObject pwdLogin(@Valid @RequestBody UserParamWithPassword userParamWithPassword, HttpServletResponse response, HttpSession session) throws Exception {
        /*Key privateKey = (Key) session.getAttribute(ConstString.RSA_PRIVATE_KEY);*/
        String phoneNumber = /*EncryptUtil.rsaDecrypt(*/userParamWithPassword.getPhoneNumber()/*, privateKey)*/;
        String password = /*EncryptUtil.rsaDecrypt(*/userParamWithPassword.getPassword()/*, privateKey)*/;

        Rider rider = riderService.findByPhoneNumber(phoneNumber);

        if (ObjectUtils.isEmpty(rider) || !StringUtils.equals(password, rider.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        produceCookieAndSession(response, session, userParamWithPassword, RIDER_PHONE_NUMBER, RIDER_TOKEN);

        return new SuccessResponse();
    }

    @PostMapping
    @ApiOperation("骑手注册接口")
    @ApiImplicitParam(name = "rider", value = "用户上传骑手信息", required = true, dataType = "Rider")
    public ResponseObject saveRider(@Valid @RequestBody Rider rider) {
        return new SuccessResponse(riderService.saveRider(rider));
    }

    @PutMapping("/riderPassword")
    @ApiOperation("骑手修改密码接口")
    @ApiImplicitParam(name = "userParamForChangePassword", value = "骑手提交密码修改信息", required = true, dataType = "UserParamForChangePassword")
    public ResponseObject updateRiderPassword(@Valid @RequestBody UserParamForChangePassword userParamForChangePassword) {
        String phoneNumber = /*EncryptUtil.rsaDecrypt(*/userParamForChangePassword.getPhoneNumber()/*, privateKey)*/;
        String password = /*EncryptUtil.rsaDecrypt(*/userParamForChangePassword.getPassword()/*, privateKey)*/;
        String newPassword = /*EncryptUtil.rsaDecrypt(*/userParamForChangePassword.getNewPassword()/*, privateKey)*/;

        Rider rider = riderService.findByPhoneNumber(phoneNumber);

        if (ObjectUtils.isEmpty(rider) || !StringUtils.equals(password, rider.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        return new SuccessResponse(riderService.updateRiderPassword(phoneNumber, newPassword));
    }

    @PutMapping("/rider/payedDeposit")
    @ApiOperation("骑手缴纳保证金后，更新是否已缴纳的接口")
    @ApiImplicitParams(@ApiImplicitParam(name = "userParam", value = "手机号", required = true, dataType = "UserParam"))
    public ResponseObject payedDeposit(@Valid @RequestBody UserParam userParam) {
        return riderService.payedDeposit(userParam.getPhoneNumber(), DEPOSIT_AMOUNT)
                ? new SuccessResponse() : new FailResponse("手机号对应的骑手信息不存在");
    }
}
