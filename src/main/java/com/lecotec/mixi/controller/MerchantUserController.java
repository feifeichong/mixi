package com.lecotec.mixi.controller;

import com.lecotec.mixi.common.RandomUtil;
import com.lecotec.mixi.model.entity.MerchantUser;
import com.lecotec.mixi.model.parameter.UserParamForChangePassword;
import com.lecotec.mixi.model.parameter.UserParamWithPassword;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.MerchantUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.lecotec.mixi.common.AuthorityUtil.produceCookie;
import static com.lecotec.mixi.common.ConstString.*;

@RestController
@RequestMapping("/api/merchant/merchantUser")
@Api(tags = "后台用户接口")
public class MerchantUserController {

    @Autowired
    private MerchantUserService merchantUserService;

    @PostMapping("/login/pwdLogin")
    @ApiOperation("商家登录接口（手机号、密码）")
    public ResponseObject pwdLogin(@Valid @RequestBody UserParamWithPassword userParamWithPassword, HttpServletResponse response, HttpSession session) throws Exception {
        String phoneNumber = userParamWithPassword.getPhoneNumber();
        String password = userParamWithPassword.getPassword();

        MerchantUser merchantUser = merchantUserService.findByPhoneNumber(phoneNumber);

        if (ObjectUtils.isEmpty(merchantUser) || !StringUtils.equals(password, merchantUser.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        response.addCookie(produceCookie(MERCHANT_USER_PHONE_NUMBER, merchantUser.getPhoneNumber()));
        response.addCookie(produceCookie(MERCHANT_USER_NAME, merchantUser.getName()));
        response.addCookie(produceCookie(MERCHANT_USER_TYPE, merchantUser.getMerchantUserType()));

        String token = RandomUtil.getRandomToken();
        response.addCookie(produceCookie(MERCHANT_USER_TOKEN, token));

        session.setAttribute(MERCHANT, merchantUser);
        session.setAttribute(MERCHANT_USER_TOKEN, token);

        return new SuccessResponse();
    }

    @PostMapping
    public ResponseObject saveOrUpdateMerchantUser(@Valid @RequestBody MerchantUser merchantUser) {
        return new SuccessResponse(merchantUserService.saveOrUpdateMerchantUser(merchantUser));
    }

    @PutMapping("/updateMerchantUserPassword")
    public ResponseObject updateMerchantUserPassword(@Valid @RequestBody UserParamForChangePassword userParamForChangePassword) {
        String phoneNumber = userParamForChangePassword.getPhoneNumber();
        String password = userParamForChangePassword.getPassword();
        String newPassword = userParamForChangePassword.getNewPassword();

        MerchantUser merchant = merchantUserService.findByPhoneNumber(phoneNumber);

        if (ObjectUtils.isEmpty(merchant) || !StringUtils.equals(password, merchant.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        return new SuccessResponse(merchantUserService.updateMerchantUserPassword(phoneNumber, newPassword));
    }

    @GetMapping("all")
    public BootstrapTableResult<MerchantUser> getMerchantUsers(int pageNumber, int pageSize) {
        Page<MerchantUser> merchantUsers = merchantUserService.getMerchantUsers(pageNumber, pageSize);
        return new BootstrapTableResult<>(merchantUsers.getTotalElements(), merchantUsers.getContent());
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteMerchantUser(@PathVariable("id") long id) {
        return new SuccessResponse(merchantUserService.deleteMerchantUser(id));
    }
}
