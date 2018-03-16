package com.jk.controller;

import com.jk.entity.*;
import com.jk.service.LoginServcie;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping()
public class LoginController {

    @Resource
    private LoginServcie loginServcie;

    @Resource
    private SessionDAO customShiroSessionDAO;

    @GetMapping("")
    public String index(Model model,Integer pn,Integer status,Integer recommend,String category_id,HttpServletRequest req)
    {
        List<Post> emps = loginServcie.getAll(status,model,pn,recommend,category_id);
        PageInfo<Post> pageInfo = new PageInfo<Post>(emps,5);
        model.addAttribute("pageInfo",pageInfo);
        String str = loginServcie.certification(req);
        model.addAttribute("certification",str);
        return "/index";
    }

    @GetMapping("logintz")
    public String logintz(String forceLogout,Model model)
    {
        if(forceLogout!=null)
        {
            model.addAttribute("forceLogout",1);
        }
        return "/index/login";
    }

    @GetMapping("register")
    public String register()
    {
        return "index/register";
    }

    @GetMapping("active")
    public String active()
    {
        return "/index/active";
    }



    @PostMapping(value="doLogin",produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String,Object> doLogin(String email, String password, String vercode,String rememberMe,HttpServletRequest req,Integer forceLogout)
    {

        boolean equals1 = Objects.equals(rememberMe, "1");
        UsernamePasswordToken token = new UsernamePasswordToken(email, password,equals1,vercode);
        Subject currentUser = SecurityUtils.getSubject();
        Map<String,Object> map = new HashMap<>();

        SavedRequest savedRequest = WebUtils.getSavedRequest(req);//获取shiro存取记录

        if (savedRequest == null || savedRequest.getRequestUrl() == null) {
            //为空 则为正常跳转 但对ajax无效
            map.put("url","/");
        }else {
            //不为空 则为阻拦跳转的网址 返回到前台
            map.put("url",savedRequest.getRequestUrl());
        }






        try {
            currentUser.login(token);
            //获取用户登陆成功后的信息
            Object principal = currentUser.getPrincipal();
            System.out.println(principal+"--------------------------------");
            map.put("msg","登陆成功");
        } catch (UnknownAccountException uae) {
            map.put("msg","没有此账户");
        }catch (IncorrectCredentialsException ice) {
            map.put("msg","密码错误");
        }catch (AuthenticationException ae) {
            map.put("msg","验证码错误, 请重试!");
        }
        return map;
        //String attribute = (String) req.getSession().getAttribute("rand");
        //return  "";
    }


    @PostMapping(value="doRegister",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String doRegister(User user, String vercode,HttpServletRequest req)
    {
        return  loginServcie.insertUser(user,vercode,req);
    }

    @GetMapping("post/{postid}")
    public String post(Model model,@PathVariable("postid")String postid,Integer pn,HttpServletRequest req)
    {
        Post post = loginServcie.tiziXq(postid,req,model);
        model.addAttribute("post",post);
        List<Comment> listComment = loginServcie.listComment(postid,pn);
        PageInfo pageInfo = new PageInfo<>(listComment,5);
        model.addAttribute("pageInfo",pageInfo);
        return "/post/post";
    }



    //shiro测试
    /*@RequiresPermissions("yy")*/
    @GetMapping("shiro")
    public String shiro()
    {
        return "indexTwo";
    }

    /*@RequiresPermissions("yy")*/
    @GetMapping("shiroOne")
    public String shiroOne()
    {
        return "index";
    }

    //获取所有在线的用户！！
    @GetMapping("online")
    public String online(Model model)
    {
        model.addAttribute("online",onlineSelect());
        return "online";
    }

    @PostMapping("exitUser/{id}")
    @ResponseBody
    public Object exitUser(@PathVariable("id")String id,Model model)
    {
        try {
            Session session = customShiroSessionDAO.readSession(id);
            if(session != null)
            {
                session.setAttribute("out", true);
            }
            //customShiroSessionDAO.delete(session);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }


    public List<UserOnline> onlineSelect()
    {

        Collection<Session> activeSessions = customShiroSessionDAO.getActiveSessions();
        List<UserOnline> list = new ArrayList<>();
        for (Session session : activeSessions) {
            UserOnline userOnline = new UserOnline();
            String out = String.valueOf(session.getAttribute("out"));
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null || out.equals("true")) {
                continue;
            } else {
                Object attribute = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                userOnline.setUserName(attribute+"");
            }
            userOnline.setId((String) session.getId());
            userOnline.setHost(session.getHost());
            userOnline.setStartTimestamp(session.getStartTimestamp());
            userOnline.setLastAccessTime(session.getLastAccessTime());
            userOnline.setTimeout(session.getTimeout());
            list.add(userOnline);
        }

        return list;
    }

    @GetMapping("diy")
    @ResponseBody
    public String diy()
    {
        return "hello world";
    }

    @GetMapping("teshu")
    public String teshu()
    {
        return "hello";
    }

    @GetMapping("roleTeShu")
    @ResponseBody
    public String roleTeShu()
    {
        return "hello roleTeShu";
    }

    @GetMapping("error")
    public String error()
    {
        return "403";
    }


    @GetMapping("github")
    @ResponseBody
    public String github()
    {
        return "github";
    }

    @GetMapping("githubTwo")
    @ResponseBody
    public String githubTwo()
    {
        return "githubTwo";
    }






}
