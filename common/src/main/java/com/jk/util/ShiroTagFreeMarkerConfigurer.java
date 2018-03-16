/** 
 * <pre>项目名称:controller 
 * 文件名称:ShiroTagFreeMarkerConfigurer.java 
 * 包名:com.jk.shiro 
 * 创建日期:2017年10月31日下午3:51:57 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.util;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/** 
 * <pre>项目名称：controller    
 * 类名称：ShiroTagFreeMarkerConfigurer    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年10月31日 下午3:51:57    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年10月31日 下午3:51:57    
 * 修改备注：       
 * @version </pre>    
 */
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {

	@Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }
	
}
