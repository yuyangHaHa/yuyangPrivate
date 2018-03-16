package com.jk.shiro;

import com.jk.entity.User;
import com.jk.mapper.LoginMapper;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Collection;
import java.util.List;

public class SpecialRememberMe extends FormAuthenticationFilter {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){

        Subject subject = getSubject(request, response);
        Session session = subject.getSession();

        System.out.println(session.getAttribute("out")+"3--------------------------------------");
        if(!subject.isAuthenticated() && subject.isRemembered() && session.getAttribute("kehu")==null)
        {
            Object principal = subject.getPrincipal();
            if(principal!=null)
            {
                String string = principal.toString();
                List<User> userList = loginMapper.doLogin(string);
                session.setAttribute("kehu",userList.get(0));
            }
        }

        return true;
    }


}
