package com.lecotec.mixi.aop;

import com.alibaba.fastjson.JSON;
import com.lecotec.mixi.common.ConstString;
import com.lecotec.mixi.model.entity.Merchant;
import com.lecotec.mixi.model.response.FailResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.lecotec.mixi.common.ConstString.MERCHANT;
import static com.lecotec.mixi.common.ConstString.MERCHANT_TOKEN;

public class MerchantTokenCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Cookie[] cookies = request.getCookies();
        if (ObjectUtils.isEmpty(cookies))
            return false;

        String merchantPhoneNumber = "";
        String merchantUserType = "";
        String merchantToken = "";
        for (Cookie cookie : cookies) {
            switch (cookie.getName()) {
                case ConstString.MERCHANT_PHONE_NUMBER:
                    merchantPhoneNumber = cookie.getValue();
                    break;
                case ConstString.MERCHANT_USER_TYPE:
                    merchantUserType = cookie.getValue();
                    break;
                case ConstString.MERCHANT_TOKEN:
                    merchantToken = cookie.getValue();
                    break;
            }
        }

        HttpSession session = request.getSession();
        Object merchantObj = session.getAttribute(MERCHANT);
        Object merchantTokenInServer = session.getAttribute(MERCHANT_TOKEN);

        if (StringUtils.isAnyEmpty(merchantPhoneNumber, merchantUserType, merchantToken) || ObjectUtils.isEmpty(merchantObj)
                || ObjectUtils.isEmpty(merchantTokenInServer)) {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            FailResponse responseObj = new FailResponse("您没有权限访问当前接口!");
            response.getWriter().print(JSON.toJSONString(responseObj));
            return false;
        }

        Merchant merchant = (Merchant) merchantObj;
        String merchantUserTypeInServer = merchant.getMerchantUserType();
        String merchantPhoneNumberInServer = merchant.getPhoneNumber();

        if (StringUtils.equals(merchantPhoneNumber, merchantPhoneNumberInServer)
                && StringUtils.equals(merchantUserType, merchantUserTypeInServer)
                && StringUtils.equals(merchantToken, merchantTokenInServer.toString())) {
            return true;
        }

        return false;
    }
}
