package com.jk.shiroDiy;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class twoDiy extends FormAuthenticationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        System.out.println("第三个方法++++++++++++++++++++++++++++++++++++++++++++");
        return false;
    }
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("第四个方法++++++++++++++++++++++++++++++++++++++++++++");
        return true;
    }
}
