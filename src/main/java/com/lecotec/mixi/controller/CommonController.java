package com.lecotec.mixi.controller;

import com.lecotec.mixi.common.AuthorityUtil;
import com.lecotec.mixi.common.EncryptUtil;
import com.lecotec.mixi.common.RandomUtil;
import com.lecotec.mixi.model.parameter.UserParamWithUserType;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.lecotec.mixi.common.ConstString.RSA_PRIVATE_KEY;
import static com.lecotec.mixi.common.ConstString.RSA_PUBLIC_KEY;

@RestController
@RequestMapping("/api/common")
@Api(tags = "公共模块接口")
public class CommonController {

    @GetMapping("/rsaPublicKey")
    @ApiOperation("获取RSA加密公钥")
    public ResponseObject getRsaPublicKey(HttpSession session) throws NoSuchAlgorithmException {
        Object pubKey = session.getAttribute(RSA_PUBLIC_KEY);
        if (pubKey != null)
            return new SuccessResponse(pubKey);

        KeyPair keyPair = EncryptUtil.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        String modulus = new String(Hex.encodeHex(publicKey.getModulus().toByteArray()));
        String exponent = new String(Hex.encodeHex(publicKey.getPublicExponent().toByteArray()));

        Map<String, String> pubKeyMap = new HashMap<>();
        pubKeyMap.put("modulus", modulus);
        pubKeyMap.put("exponent", exponent);

        session.setAttribute(RSA_PUBLIC_KEY, pubKeyMap);
        session.setAttribute(RSA_PRIVATE_KEY, privateKey);

        return new SuccessResponse(pubKeyMap);
    }

    @GetMapping("/shortMsgCode")
    @ApiOperation("获取手机短信验证码")
    @ApiImplicitParam(name = "phoneNumber", value = "手机号", required = true, dataType = "String")
    public ResponseObject getShortMsgCode(String phoneNumber, HttpSession session) {
        if (!Pattern.matches("1\\d{10}", phoneNumber))
            return new FailResponse("输入的手机号有误");

        int shortMsgCode = RandomUtil.getRandomNum();
        session.setAttribute(phoneNumber, shortMsgCode);
        return new SuccessResponse(shortMsgCode);
    }

    @PostMapping("/shortMsgCodeCheck")
    @ApiOperation("手机短信验证码校验")
    @ApiImplicitParam(name = "userParamWithUserType", value = "手机号、短信验证码、用户类型(CUSTOMER, RIDER, MERCHANT)", required = true, dataType = "UserParamWithUserType")
    public ResponseObject shortMsgCodeCheck(@Valid @RequestBody UserParamWithUserType userParamWithUserType, HttpServletResponse response, HttpSession session) throws Exception {
        /*Key privateKey = (Key) session.getAttribute(ConstString.RSA_PRIVATE_KEY);*/
        String phoneNumber = /*EncryptUtil.rsaDecrypt(*/userParamWithUserType.getPhoneNumber()/*, privateKey)*/;
        String shortMsgCode = /*EncryptUtil.rsaDecrypt(*/userParamWithUserType.getShortMsgCode()/*, privateKey)*/;

        Object shortMsgCodeInServer = session.getAttribute(phoneNumber);

        if (!StringUtils.equals(shortMsgCode, shortMsgCodeInServer == null ? "" : shortMsgCodeInServer.toString())) {
            return new FailResponse("手机号或者短信验证码错误！");
        }

        AuthorityUtil.produceAuthority(response, session, userParamWithUserType);
        return new SuccessResponse();
    }
}
