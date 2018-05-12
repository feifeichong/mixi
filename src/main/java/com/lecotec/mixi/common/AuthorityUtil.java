package com.lecotec.mixi.common;

import com.lecotec.mixi.model.parameter.UserParam;
import com.lecotec.mixi.model.parameter.UserParamWithUserType;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.lecotec.mixi.common.ConstString.*;

public class AuthorityUtil {

    public static void produceAuthority(HttpServletResponse response, HttpSession session, UserParamWithUserType userParam) throws Exception {
        switch (userParam.getUserType()) {
            case CUSTOMER:
                produceCookieAndSession(response, session, userParam, CUSTOMER_PHONE_NUMBER, CUSTOMER_TOKEN);
                break;
            case RIDER:
                produceCookieAndSession(response, session, userParam, RIDER_PHONE_NUMBER, RIDER_TOKEN);
                break;
            case MERCHANT:
                produceCookieAndSession(response, session, userParam, MERCHANT_PHONE_NUMBER, MERCHANT_TOKEN);
                break;
        }
    }

    public static void produceCookieAndSession(HttpServletResponse response, HttpSession session, UserParam userParam, String userPhoneNumberKey, String userTokenType) throws Exception {
        Cookie userIdCookie = produceCookie(userPhoneNumberKey, userParam.getPhoneNumber());
        response.addCookie(userIdCookie);
        session.setAttribute(userPhoneNumberKey, userParam.getPhoneNumber());

        String token = RandomUtil.getRandomToken();
        Cookie tokenCookie = produceCookie(userTokenType, token);
        response.addCookie(tokenCookie);
        session.setAttribute(userTokenType, token);
    }

    public static Cookie produceCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        return cookie;
    }
}
