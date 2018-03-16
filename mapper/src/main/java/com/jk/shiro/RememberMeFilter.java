package com.jk.shiro;

import com.jk.entity.User;
import com.jk.mapper.LoginMapper;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

public class RememberMeFilter extends FormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(CaptchaFormAuthenticationFilter.class);

    @Autowired
    private LoginMapper loginMapper;



    /**
     * 记住我的功能肯定isAuthenticated()为false，isRemembered()为true
     *  session.getAttribute("kehu")==null再去获取，不然会频繁执行下面的代码
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){

        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        System.out.println(session.getAttribute("out")+"2--------------------------------------");
        if(!subject.isAuthenticated() && subject.isRemembered() && session.getAttribute("kehu")==null)
        {
            //说明是记住我功能
            Object principal = subject.getPrincipal();
            //获取用户资料
            if(principal!=null)
            {
                String string = principal.toString();
                List<User> userList = loginMapper.doLogin(string);
                session.setAttribute("kehu",userList.get(0));
            }
        }

        return subject.isAuthenticated() || subject.isRemembered();
    }



    /**
     * 所有请求都会经过的方法。
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        if(session.getAttribute("kehu")==null){
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
        }
        // return true 为往下执行 并且不阻拦 return false 为往下不执行 也不重定向到登录页面了
        // return true 会和 saveRequestAndRedirectToLogin(request,response) 矛盾
        return false;
    }


}
