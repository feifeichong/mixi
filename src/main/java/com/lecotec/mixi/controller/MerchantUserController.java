package com.lecotec.mixi.controller;

import com.lecotec.mixi.common.ConstString;
import com.lecotec.mixi.common.EncryptUtil;
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
import java.security.Key;

import static com.lecotec.mixi.common.AuthorityUtil.produceCookie;
import static com.lecotec.mixi.common.ConstString.*;

@RestController
@RequestMapping("/api/merchant")
@Api(tags = "商家登录、注册、忘记密码和修改密码接口集合")
public class MerchantUserController {

    @Autowired
    private MerchantUserService merchantUserService;

    @PostMapping("/login/pwdLogin")
    @ApiOperation("商家登录接口（手机号、密码），调用之前先获取RSA公钥，加密密码(先用md5转码)")
    public ResponseObject pwdLogin(@Valid @RequestBody UserParamWithPassword userParamWithPassword, HttpServletResponse response, HttpSession session) throws Exception {
        Key privateKey = (Key) session.getAttribute(ConstString.RSA_PRIVATE_KEY);
        String phoneNumber = userParamWithPassword.getPhoneNumber();
        String password = EncryptUtil.rsaDecrypt(userParamWithPassword.getPassword(), privateKey);

        MerchantUser merchant = merchantUserService.findByPhoneNumber(phoneNumber);

        if (ObjectUtils.isEmpty(merchant) || !StringUtils.equals(password, merchant.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        response.addCookie(produceCookie(MERCHANT_PHONE_NUMBER, phoneNumber));
        response.addCookie(produceCookie(MERCHANT_USER_TYPE, merchant.getMerchantUserType()));
        String token = RandomUtil.getRandomToken();
        response.addCookie(produceCookie(MERCHANT_TOKEN, token));

        session.setAttribute(MERCHANT, merchant);
        session.setAttribute(MERCHANT_TOKEN, token);

        return new SuccessResponse(merchant);
    }

    @PostMapping
    public ResponseObject saveMerchant(@Valid @RequestBody MerchantUser merchant) {
        return new SuccessResponse(merchantUserService.saveMerchant(merchant));
    }

    @PutMapping("/updateMerchantPassword")
    public ResponseObject updateMerchantPassword(@Valid @RequestBody UserParamForChangePassword userParamForChangePassword) {
        String phoneNumber = /*EncryptUtil.rsaDecrypt(*/userParamForChangePassword.getPhoneNumber()/*, privateKey)*/;
        String password = /*EncryptUtil.rsaDecrypt(*/userParamForChangePassword.getPassword()/*, privateKey)*/;
        String newPassword = /*EncryptUtil.rsaDecrypt(*/userParamForChangePassword.getNewPassword()/*, privateKey)*/;

        MerchantUser merchant = merchantUserService.findByPhoneNumber(phoneNumber);

        if (ObjectUtils.isEmpty(merchant) || !StringUtils.equals(password, merchant.getPassword())) {
            return new FailResponse("手机号或者密码错误！");
        }

        return new SuccessResponse(merchantUserService.updateMerchantPassword(phoneNumber, newPassword));
    }

    @GetMapping("all")
    public BootstrapTableResult<MerchantUser> getMerchants(int pageNumber, int pageSize) {
        Page<MerchantUser> merchants = merchantUserService.getMerchants(pageNumber, pageSize);
        return new BootstrapTableResult<>(merchants.getTotalElements(), merchants.getContent());
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteMerchant(@PathVariable("id") long id) {
        return new SuccessResponse(merchantUserService.deleteMerchant(id));
    }
}
