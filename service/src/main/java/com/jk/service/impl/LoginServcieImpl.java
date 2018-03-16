package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.entity.*;
import com.jk.mapper.LoginMapper;
import com.jk.service.LoginServcie;
import com.jk.util.EncryptUtils;
import com.jk.util.TimeDifference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LoginServcieImpl implements LoginServcie {

    @Autowired
    private LoginMapper loginMapper;



    @Override
    public String doLogin(String email, String password, String vercode, HttpServletRequest req) {


        String attribute = (String) req.getSession().getAttribute("rand");
        if(!attribute.equals(vercode))
        {
            return "验证码错误";
        }
        List<User> userList = loginMapper.doLogin(email);
        if(userList.size()>0)
        {
            String password1 = EncryptUtils.encryptPassword(password, userList.get(0).getSalt());
            if(userList.get(0).getPassword().equals(password1))
            {
                req.getSession().setAttribute("kehu",userList.get(0));
                return "登录成功";
            }
            else
            {
                return "密码错误";
            }
        }
        else {
            return "没有此账户";
        }

    }


    @Override
    public String insertUser(User user, String vercode,HttpServletRequest req) {
        String attribute = (String) req.getSession().getAttribute("rand");
        if(!attribute.equals(vercode))
        {
            return "验证码错误";
        }
        List<User> userList = loginMapper.doLogin(user.getEmail());
        if(userList.size()>0)
        {
            return "已存在此账户";
        }
        else {

            //1 id
            String string = UUID.randomUUID().toString();
            String all = string.replaceAll("-", "");
            //2 salt
            String salt = EncryptUtils.generateSalt();
            //3 password
            String password = EncryptUtils.encryptPassword(user.getPassword(), salt);
            //4
            //-------
            user.setId(all);
            user.setSalt(salt);
            user.setPassword(password);
            user.setAvatar("/static/images/touxiang.jpg");
            user.setRole("user");
            user.setStatus(0);
            user.setCreated(new Date());
            user.setModified(new Date());
            user.setLogged(new Date());
            //----------
            loginMapper.insertUser(user);
            loginMapper.updateIntegral(all,100);
            return "注册成功";
        }
    }

    @Override
    public List<Post> getAll(Integer status, Model model,Integer pn,Integer recommend,String category_id) {

        if(pn==null)
        {
            pn=1;
        }
        if(pn==1&&status==null&&recommend==null)
        {
            List<Post> listZhiDing = loginMapper.zhiDing(category_id);
            model.addAttribute("zhiding",listZhiDing);
        }
        PageHelper.startPage(pn,5);
        if(status==null)
        {
            model.addAttribute("status",null);
        }
        else
        {
            model.addAttribute("status",status);
        }
        if(recommend==null)
        {
            model.addAttribute("recommend",null);
        }
        else
        {
            model.addAttribute("recommend",recommend);
        }
        if(category_id==null)
        {
            model.addAttribute("category_id",null);
        }
        else
        {
            model.addAttribute("category_id",category_id);
        }
        return loginMapper.getAll(status,recommend,category_id);
    }


    @Override
    public Post tiziXq(String postid,HttpServletRequest req,Model model) {
        User user = (User) req.getSession().getAttribute("kehu");
        if(user!=null)
        {
            UserCollection userCollection = loginMapper.userCollectionCollection(postid,user.getId());
            if(userCollection!=null)
            {
                model.addAttribute("userCollection",userCollection);
            }
            else{
                model.addAttribute("userCollection",null);
            }
        }
        return loginMapper.tiziXq(postid);
    }

    @Override
    public List<Comment> listComment(String postid,Integer pn) {
        if(pn==null)
        {
            pn=1;
        }
        PageHelper.startPage(pn,5);
        List<Comment> listComment = loginMapper.listComment(postid);
        return listComment;
    }

    @Override
    public void insertHuiFu(String content,String to_id,String id,HttpServletRequest req) {
        Comment comment = new Comment();
        //1 id
        String string = UUID.randomUUID().toString();
        String all = string.replaceAll("-", "");
        //2 user
        User user = (User) req.getSession().getAttribute("kehu");
        //3 ip
        String remoteAddr = req.getRemoteAddr();
        //---------
        comment.setId(all);
        comment.setPost_id(id);
        if(user!=null){comment.setUser_id(user.getId());}
        comment.setContent(content);
        comment.setUser_ip(remoteAddr);
        comment.setUser_agent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36");
        comment.setCreated(new Date());
        loginMapper.insertHuiFu(comment);
        //active
        UserAction userAction = new UserAction();
        //active-id
        userAction.setId(all);
        //active-post-id
        userAction.setPost_id(id);
        //active-comment-id
        userAction.setComment_id(all);
        //active-user-id
        userAction.setUser_id(user.getId());
        //active-active
        userAction.setAction("new_comment");
        //active-point
        userAction.setPoint(2);
        //active-create
        userAction.setCreated(new Date());
        loginMapper.insertUserAction(userAction);

        //UserMessage
        UserMessage userMessage = new UserMessage();
        userMessage.setId(all);
        userMessage.setFrom_user_id(user.getId());
        userMessage.setTo_user_id(to_id);
        userMessage.setPost_id(id);
        userMessage.setComment_id(all);
        userMessage.setType(1);
        userMessage.setCreated(new Date());
        loginMapper.insertUserMessage(userMessage);
        loginMapper.updateIntegral(user.getId(),2);
    }

    @Override
    public void updatePostTure(Post post) {
        loginMapper.updatePostTure(post);
    }

    @Override
    public void insertPostTure(Post post,HttpServletRequest req) {
        //1 id
        String string = UUID.randomUUID().toString();
        String all = string.replaceAll("-", "");
        //2 user id
        User user = (User) req.getSession().getAttribute("kehu");
        //3 ip
        String remoteAddr = req.getRemoteAddr();

        //-------------
        post.setId(all);
        post.setEdit_mode("html");
        post.setUser_id(user.getId());
        post.setUser_ip(remoteAddr);
        post.setUser_agent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        post.setCreated(new Date());
        loginMapper.insertPostTure(post);
        //active
        UserAction userAction = new UserAction();
        //active-id
        userAction.setId(all);
        //active-post-id
        userAction.setPost_id(all);
        //active-user-id
        userAction.setUser_id(user.getId());
        //active-active
        userAction.setAction("new_post");
        //active-point
        userAction.setPoint(10);
        //active-create
        userAction.setCreated(new Date());
        loginMapper.insertUserAction(userAction);
        loginMapper.updateIntegral(user.getId(),10);
    }

    @Override
    public String updateAdopt(String postid, String commentid,HttpServletRequest req,Long pay_point,String commentid_user) {
        Post post = loginMapper.judgeToAdopt(postid);
        if(post.getStatus()==0)
        {
            loginMapper.updatePostAdopt(postid);
            loginMapper.updateCommentAdopt(commentid);

            //1 id
            String string = UUID.randomUUID().toString();
            String all = string.replaceAll("-", "");
            //2 user id
            User user = (User) req.getSession().getAttribute("kehu");
            //active
            UserAction userAction = new UserAction();
            //active-id
            userAction.setId(all);
            //active-post-id
            userAction.setPost_id(postid);
            //active-user-id
            userAction.setUser_id(user.getId());
            //active-active
            userAction.setAction("finished_post");
            //active-point
            userAction.setPoint(pay_point);
            //active-create
            userAction.setCreated(new Date());
            loginMapper.insertUserAction(userAction);
            //1 idtwo
            String stringtwo = UUID.randomUUID().toString();
            String alltwo = stringtwo.replaceAll("-", "");
            //idtwo
            userAction.setId(alltwo);
            //commentid
            userAction.setComment_id(commentid);
            //active-active
            userAction.setAction("comment_adopted");
            loginMapper.insertUserAction(userAction);
            loginMapper.updateIntegral(commentid_user,Integer.valueOf(pay_point+""));
            return "";
        }
        else
        {
            return "此帖子已经结贴了";
        }
    }

    @Override
    public void insertCollection(String postid,HttpServletRequest req,String posttitle) {

        UserCollection userCollection = new UserCollection();

        //1 user id
        User user = (User) req.getSession().getAttribute("kehu");
        //2 id
        String string = UUID.randomUUID().toString();
        String all = string.replaceAll("-", "");

        //---------
        userCollection.setId(all);
        if(user!=null){userCollection.setUser_id(user.getId());}
        userCollection.setPost_id(postid);
        userCollection.setPost_title(posttitle);
        userCollection.setCreated(new Date());

        loginMapper.insertCollection(userCollection);

    }

    @Override
    public void deleteCollection(String postid,HttpServletRequest req,String posttitle) {

        //1 user id
        User user = (User) req.getSession().getAttribute("kehu");

        loginMapper.deleteCollection(postid,user.getId());

    }

    @Override
    public void operationFore(Integer state, String postid) {
        switch(state)
        {
            case 0:
                loginMapper.deleteCollectionPost(postid);
                loginMapper.deleteCollectionComment(postid);
                break;
            case 66:
                loginMapper.updatePostTop(postid);
                break;
            case 88:
                loginMapper.updatePostEssence(postid);
                break;
            case 888:
                loginMapper.updatePostCancelEssence(postid);
                break;
            default:
                loginMapper.updatePost(postid,state);
        }
    }


    @Override
    public List<Post> userPost(String userid) {
        return loginMapper.userPost(userid);
    }

    @Override
    public List<UserAction> userAction(String userid) {
        return loginMapper.userAction(userid);
    }

    @Override
    public void updateDoSetting(User user,HttpServletRequest req) {
        //1 user id
        User users = (User) req.getSession().getAttribute("kehu");
        user.setId(users.getId());
        loginMapper.updateDoSetting(user);
        List<User> userList = loginMapper.doLogin(users.getEmail());
        req.getSession().setAttribute("kehu",userList.get(0));
    }

    @Override
    public void updateUserImg(HttpServletRequest req, String s) {
        //1 user id
        User users = (User) req.getSession().getAttribute("kehu");
        loginMapper.updateUserImg(users.getId(),s);
        List<User> userList = loginMapper.doLogin(users.getEmail());
        req.getSession().setAttribute("kehu",userList.get(0));
    }


    @Override
    public String updateUserPassword(String nowpassword, String password,String repassword,HttpServletRequest req) {
        //1 user id
        User users = (User) req.getSession().getAttribute("kehu");

        if(!password.equals(repassword))
        {
            return "密码不一致!";
        }
        //salt
        boolean verlifyPassword = EncryptUtils.verlifyPassword(nowpassword, users.getSalt(), users.getPassword());
        if(verlifyPassword)
        {
            String password1 = EncryptUtils.encryptPassword(password, users.getSalt());
            loginMapper.updateUserPassword(users.getId(),password1);
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
            return "密码修改成功,重新登录";
        }
        else {
            return "密码错误!";
        }
    }

    @Override
    public PageInfo personalPost(Model model, HttpServletRequest request, Integer pn) {
        //1 user id
        User users = (User) request.getSession().getAttribute("kehu");
        if(pn==null){pn=1;}
        PageHelper.startPage(pn,5);
        List<Post> personalList = loginMapper.personalPost(users.getId());
        PageInfo pageInfo = new PageInfo<>(personalList,5);
        return pageInfo;
    }


    @Override
    public PageInfo collectionPost(HttpServletRequest request, Integer pn) {
        User users = (User) request.getSession().getAttribute("kehu");
        if(pn==null){pn=1;}
        PageHelper.startPage(pn,5);
        List<UserCollection> collectionList = loginMapper.collectionPost(users.getId());
        PageInfo pageInfo = new PageInfo<>(collectionList,5);
        return pageInfo;
    }

    @Override
    public PageInfo personalInformation(HttpServletRequest req, Integer pn) {
        User users = (User) req.getSession().getAttribute("kehu");
        if(pn==null){pn=1;}
        PageHelper.startPage(pn,5);
        List<UserMessage> messageList = loginMapper.personalInformation(users.getId());
        for (UserMessage userMessage:messageList) {
            Date created = userMessage.getCreated();
            String datePoor = TimeDifference.getDatePoor(new Date(), created);
            userMessage.setTimeDifferencel(datePoor);
        }
        PageInfo pageInfo = new PageInfo<>(messageList,5);
        return pageInfo;
    }

    @Override
    public void deleteMessage(String messageId) {
        loginMapper.deleteMessage(messageId);
    }

    @Override
    public void deleteAllMessage(HttpServletRequest req) {
        //1 user id
        User users = (User) req.getSession().getAttribute("kehu");
        loginMapper.deleteAllMessage(users.getId());      ;
    }

    @Override
    public String certification(HttpServletRequest req) {
        //1 user id
        User users = (User) req.getSession().getAttribute("kehu");
        if(users==null)
        {
            return  "0";
        }
        else {
            UserAction userAction = loginMapper.certification(users.getId());
            if(userAction==null)
            {
                return "1";
            }
            else {
                return "2";
            }
        }
    }

    @Override
    public void insertCertification(HttpServletRequest req, UserAction userAction) {
        //1 user id
        User user = (User) req.getSession().getAttribute("kehu");
        //2 id
        String string = UUID.randomUUID().toString();
        String all = string.replaceAll("-", "");


        userAction.setId(all);
        userAction.setUser_id(user.getId());
        userAction.setAction("sign_in");
        userAction.setPoint(5);
        userAction.setCreated(new Date());

        loginMapper.insertCertification(userAction);
        loginMapper.updateIntegral(user.getId(),5);
    }

    @Override
    public void updateIntegral(HttpServletRequest req, Integer integral) {
        //1 user id
        User user = (User) req.getSession().getAttribute("kehu");
        if(user!=null)
        {
            loginMapper.updateIntegral(user.getId(),integral);
        }
    }
}
