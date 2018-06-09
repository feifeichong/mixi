package com.lecotec.mixi.controller;

import com.lecotec.mixi.common.RandomUtil;
import com.lecotec.mixi.model.entity.MerchantUser;
import com.lecotec.mixi.model.parameter.MerchantUserLoginParam;
import com.lecotec.mixi.model.parameter.UserParamForChangePassword;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.MerchantUserService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Base64Utils;
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
    public ResponseObject pwdLogin(@Valid @RequestBody MerchantUserLoginParam merchantUserLoginParam, HttpServletResponse response, HttpSession session) throws Exception {
        String account = merchantUserLoginParam.getAccount();
        String password = merchantUserLoginParam.getPassword();

        MerchantUser merchantUser = merchantUserService.findByAccount(account);

        if (ObjectUtils.isEmpty(merchantUser) || !StringUtils.equals(password, merchantUser.getPassword())) {
            return new FailResponse("帐户名或者密码错误！");
        }

        response.addCookie(produceCookie(MERCHANT_USER_ACCOUNT, merchantUser.getAccount()));
        response.addCookie(produceCookie(MERCHANT_USER_NAME, merchantUser.getName()));
        response.addCookie(produceCookie(MERCHANT_USER_TYPE, merchantUser.getMerchantUserType().getName()));
        response.addCookie(produceCookie(MERCHANT_USER_TYPE_PERMISSIONS, Base64Utils.encodeToString(merchantUser.getMerchantUserType().getPermissionJson().getBytes("utf-8"))));

        String token = RandomUtil.getRandomToken();
        response.addCookie(produceCookie(MERCHANT_USER_TOKEN, token));

        session.setAttribute(MERCHANT, merchantUser);
        session.setAttribute(MERCHANT_USER_TOKEN, token);

        return new SuccessResponse();
    }

    @PostMapping
    public ResponseObject saveOrUpdate(@Valid @RequestBody MerchantUser merchantUser) {
        return new SuccessResponse(merchantUserService.saveOrUpdate(merchantUser));
    }

    @PutMapping("/updatePassword")
    public ResponseObject updatePassword(@Valid @RequestBody UserParamForChangePassword userParamForChangePassword) {
        String phoneNumber = userParamForChangePassword.getPhoneNumber();
        String password = userParamForChangePassword.getPassword();
        String newPassword = userParamForChangePassword.getNewPassword();

        MerchantUser merchant = merchantUserService.findByAccount(phoneNumber);

        if (ObjectUtils.isEmpty(merchant) || !StringUtils.equals(password, merchant.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        return new SuccessResponse(merchantUserService.updatePassword(phoneNumber, newPassword));
    }

    @GetMapping("/list")
    public BootstrapTableResult<MerchantUser> getAllByPage(int pageNumber, int pageSize) {
        Page<MerchantUser> merchantUsers = merchantUserService.getMerchantUsers(pageNumber, pageSize);
        return new BootstrapTableResult<>(merchantUsers.getTotalElements(), merchantUsers.getContent());
    }

    @GetMapping("/{account}")
    public ResponseObject findOneByAccount(@PathVariable("account") String account) {
        return new SuccessResponse(merchantUserService.findByAccount(account));
    }

    @PutMapping("changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(merchantUserService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable("id") long id) {
        return new SuccessResponse(merchantUserService.delete(id));
    }
}
