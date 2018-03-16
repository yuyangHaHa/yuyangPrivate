package com.jk.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-3-16
 * <p>Version: 1.0
 */
public class ForceLogoutFilter extends AccessControlFilter {

    @Resource
    private SessionDAO customShiroSessionDAO;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Session session = getSubject(request, response).getSession(false);
        if(session == null) {
            return true;
        }
        System.out.println(session.getAttribute("out")+"1------------------------------");
        return session.getAttribute("out") == null;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        try {
            getSubject(request, response).logout();//强制退出
        } catch (Exception e) {/*ignore exception*/}
        Session session = subject.getSession();
        if(session.getAttribute("kehu")==null){
            if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {
                // 是ajax请求
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println(getLoginUrl() + (getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1");
                out.flush();
                out.close();
            }
            else
            {
                //不是ajax 请求 则跳转登录页面
                String loginUrl = getLoginUrl() + (getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1";
                WebUtils.issueRedirect(request, response, loginUrl);
            }
        }
        return false;
    }




}
