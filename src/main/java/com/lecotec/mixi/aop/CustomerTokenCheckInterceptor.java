package com.lecotec.mixi.aop;

import com.alibaba.fastjson.JSON;
import com.lecotec.mixi.common.ConstString;
import com.lecotec.mixi.model.response.FailResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomerTokenCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Cookie[] cookies = request.getCookies();
        if (ObjectUtils.isEmpty(cookies))
            return true;

        String customerPhoneNumber = "";
        String customerToken = "";
        for (Cookie cookie : cookies) {
            switch (cookie.getName()) {
                case ConstString.CUSTOMER_PHONE_NUMBER:
                    customerPhoneNumber = cookie.getValue();
                    break;
                case ConstString.CUSTOMER_TOKEN:
                    customerToken = cookie.getValue();
                    break;
            }
        }

        if (StringUtils.isAnyEmpty(customerPhoneNumber, customerToken)) {
            response.setContentType("application/json");
            FailResponse responseObj = new FailResponse("you have no authority, please get token!");
            response.getWriter().print(JSON.toJSONString(responseObj));
            return false;
        }

        HttpSession session = request.getSession();
        Object customerPhoneNumberInServer = session.getAttribute(ConstString.CUSTOMER_PHONE_NUMBER);
        Object customerTokenInServer = session.getAttribute(ConstString.CUSTOMER_TOKEN);

        if (StringUtils.equals(customerPhoneNumber, customerPhoneNumberInServer.toString())
                && StringUtils.equals(customerToken, customerTokenInServer.toString())) {
            return true;
        }

        return false;
    }
}
