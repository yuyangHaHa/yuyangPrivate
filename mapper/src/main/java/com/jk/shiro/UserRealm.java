package com.jk.shiro;


import com.jk.entity.User;
import com.jk.entity.UserOnline;
import com.jk.mapper.LoginMapper;
import com.jk.util.EncryptUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SessionDAO customShiroSessionDAO;

    @Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO Auto-generated method stub
        String username = (String) principals.getPrimaryPrincipal();//获取name
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        HashSet hashSet = new HashSet();
        hashSet.add("yy");
        hashSet.add("yu");
        hashSet.add("yang");
        //hashSet.add("yu");
        //info.setStringPermissions(hashSet);
        info.setRoles(hashSet);
        return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	    // TODO Auto-generated method stub
         //获取基于用户名和密码的令牌
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        UsernamePasswordToken tokentwo = (UsernamePasswordToken)token;


        String code = (String)session.getAttribute("rand");
        String host = tokentwo.getHost();
        if(!code.equals(host))
        {
            throw new AuthenticationException("验证码错误, 请重试.");
        }

        List<User> userList = loginMapper.doLogin(tokentwo.getUsername());
        if(userList.size()>0)
        {
            String password2 = new String((char[]) tokentwo.getPassword());
            System.out.println(password2);
            String password = new String((char[]) token.getCredentials());
            String password1 = EncryptUtils.encryptPassword(password, userList.get(0).getSalt());
            if(userList.get(0).getPassword().equals(password1))
            {
                //相同用户登录，则顶出
                /*Collection<Session> sessions = customShiroSessionDAO.getActiveSessions();
                for(Session sessionXh:sessions) {
                    String loginUsername = String.valueOf(sessionXh.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));//获得session中已经登录用户的名字
                    if (tokentwo.getUsername().equals(loginUsername)) { //这里的username也就是当前登录的username
                        //session.setTimeout(0); //这里就把session清除，
                        customShiroSessionDAO.delete(sessionXh);
                        break;
                    }
                }*/
                //相同用户登录，则顶出


                //相同用户登录，则顶出(记住用户)
                Collection<Session> sessions = customShiroSessionDAO.getActiveSessions();
                for(Session sessionXh:sessions) {
                    String loginUsername = String.valueOf(sessionXh.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));//获得session中已经登录用户的名字
                    if (tokentwo.getUsername().equals(loginUsername)) { //这里的username也就是当前登录的username
                        //session.setTimeout(0); //这里就把session清除，
                        sessionXh.setAttribute("out",true);
                        break;
                    }
                }
                //相同用户登录，则顶出(记住用户)


                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userList.get(0).getEmail(),password,getName());
                session.setAttribute("kehu",userList.get(0));
                return info;
            }
            else
            {
                throw new IncorrectCredentialsException("密码错误");
            }
        }
        else {
            throw new UnknownAccountException("没有此账户");
        }
	}

    
}
