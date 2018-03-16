package com.jk.shiroDiy;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class teshu extends FormAuthenticationFilter {



    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        System.out.println("这是特殊方法");
        return false;
    }




}
