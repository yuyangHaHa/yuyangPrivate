/** 
 * <pre>项目名称:controller 
 * 文件名称:CustomRolesAuthorizationFilter.java 
 * 包名:com.jk.shiro 
 * 创建日期:2017年10月31日下午1:56:29 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shiroDiy;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/** 
 * <pre>项目名称：controller    
 * 类名称：CustomRolesAuthorizationFilter    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年10月31日 下午1:56:29    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年10月31日 下午1:56:29    
 * 修改备注：       
 * @version </pre>    
 */
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {

	/* (non-Javadoc)    
	 * @see org.apache.shiro.web.filter.AccessControlFilter#isAccessAllowed(javax.servlet.ServletRequest, javax.servlet.ServletResponse, java.lang.Object)    
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest arg0, ServletResponse arg1, Object arg2) throws Exception {
		Subject subject = getSubject(arg0, arg1);    
        String[] rolesArray = (String[]) arg2;    
        if (null == rolesArray || rolesArray.length == 0) { //没有角色限制，有权限访问
            return true;    
        } else {
        	for (int i = 0; i < rolesArray.length; i++) {
                if (subject.hasRole(rolesArray[i])) {
                	//若当前用户是rolesArray中的任何一个，则有权限访问
                    return true;
                }
            }
        }
        return false;
	}

}
