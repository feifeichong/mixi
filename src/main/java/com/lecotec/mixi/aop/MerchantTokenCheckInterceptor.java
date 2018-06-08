package com.lecotec.mixi.aop;

import com.alibaba.fastjson.JSON;
import com.lecotec.mixi.common.ConstString;
import com.lecotec.mixi.model.response.FailResponse;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.lecotec.mixi.common.ConstString.MERCHANT_USER_TOKEN;

public class MerchantTokenCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();

        if (ArrayUtils.isNotEmpty(cookies) && ObjectUtils.allNotNull(session)) {
            Object merchantTokenInServer = session.getAttribute(MERCHANT_USER_TOKEN);

            if (ObjectUtils.allNotNull(merchantTokenInServer)) {
                String merchantToken = "";
                for (Cookie cookie : cookies) {
                    if (ConstString.MERCHANT_USER_TOKEN.equals(cookie.getName())) {
                        merchantToken = cookie.getValue();
                        break;
                    }
                }
                return StringUtils.equals(merchantToken, merchantTokenInServer.toString());
            }
        }

        sendNoRightResponse(response);
        return false;
    }

    private void sendNoRightResponse(HttpServletResponse response) throws IOException {
        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(JSON.toJSONString(new FailResponse("您没有权限访问当前接口，请登录！")));
    }
}
