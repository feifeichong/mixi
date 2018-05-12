package com.lecotec.mixi.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MixiWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new CustomerTokenCheckInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/**/login/**");
        registry.addInterceptor(new MerchantTokenCheckInterceptor()).addPathPatterns("/api/merchant/**").excludePathPatterns("/api/merchant/login/**");
    }
}