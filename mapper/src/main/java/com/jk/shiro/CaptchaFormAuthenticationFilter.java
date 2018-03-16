package com.jk.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {


    private static final Logger log = LoggerFactory.getLogger(CaptchaFormAuthenticationFilter.class);


    /**
     * 所有请求都会经过的方法。
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {
            // 是ajax请求
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println(this.getLoginUrl());
            out.flush();
            out.close();
        }
        else
        {
            //不是ajax 请求 则跳转登录页面
            saveRequestAndRedirectToLogin(request,response);
        }
        // return true 为往下执行 并且不阻拦 return false 为往下不执行 也不重定向到登录页面了
        // return true 会和 saveRequestAndRedirectToLogin(request,response) 矛盾
        return false;
    }






}
