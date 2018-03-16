package com.jk.controller;

import com.jk.entity.*;
import com.jk.service.LoginServcie;
import com.jk.util.SpringMvcUpload;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController {

    @Resource
    private LoginServcie loginServcie;


    @PostMapping("uploadImage")
    @ResponseBody
    public Map<String,Object> uploadImage(HttpServletRequest req, MultipartFile file)
    {
        String uploadYy = SpringMvcUpload.uploadYy(req, file, "static/uploadImage");
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        map2.put("src","/static/uploadImage/"+uploadYy);
        map2.put("title",uploadYy);
        map.put("code",0);
        map.put("msg","成功");
        map.put("data",map2);
        return map;
    }

    @PostMapping("huifu")
    @ResponseBody
    public void huifu(String content,String to_id,String id,HttpServletRequest req)
    {
        loginServcie.insertHuiFu(content,to_id,id,req);
    }


    @GetMapping("updatePost/{userid}")
    public String updatePost(Model model, @PathVariable("userid")String userid,HttpServletRequest req)
    {
        Post post = loginServcie.tiziXq(userid,req,model);
        model.addAttribute("post",post);
        return "post/updatePost";
    }


    @PostMapping(value="updatePostTure",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updatePostTure(Post post,String vercode,HttpServletRequest req)
    {
        String attribute = (String) req.getSession().getAttribute("rand");
        if(!attribute.equals(vercode))
        {
            return "验证码错误";
        }
        loginServcie.updatePostTure(post);
        return "";
    }


    @GetMapping("insertPost")
    public String insertPost()
    {
        return "post/insertPost";
    }


    @PostMapping(value="insertPostTure",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String insertPostTure(Post post,String vercode,HttpServletRequest req)
    {
        String attribute = (String) req.getSession().getAttribute("rand");
        if(attribute==null)
        {
            return "验证码已经失效了！请点击验证码刷新！！";
        }
        if(!attribute.equals(vercode))
        {
            return "验证码错误";
        }
        loginServcie.insertPostTure(post,req);
        return post.getId();
    }


    @PostMapping(value="adopt",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String adopt(String postid,String commentid,HttpServletRequest req,Long pay_point,String commentid_user)
    {
        return loginServcie.updateAdopt(postid,commentid,req,pay_point,commentid_user);
    }


    @PostMapping(value="collection",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String collection(String postid,String posttitle,Integer panduanCollection,HttpServletRequest req)
    {
        if(panduanCollection==0)
        {
            loginServcie.insertCollection(postid,req,posttitle);
            return "收藏成功";
        }
        else {
            loginServcie.deleteCollection(postid,req,posttitle);
            return "已取消收藏";
        }
    }


    @PostMapping("theUserAction/{state}")
    @ResponseBody
    public void theUserAction(@PathVariable("state")Integer state,String postid)
    {
        loginServcie.operationFore(state,postid);
    }


    //----------个人

    @GetMapping("post")
    public String post(Model model,HttpServletRequest request,Integer pn)
    {

        PageInfo pageInfo = loginServcie.personalPost(model,request,pn);
        model.addAttribute("pageInfo",pageInfo);
        return "/personal/personal";
    }

    @GetMapping("postCollection")
    public String postCollection(Model model,HttpServletRequest request,Integer pn)
    {
        PageInfo pageInfo = loginServcie.collectionPost(request,pn);
        model.addAttribute("pageInfo",pageInfo);
        return "/personal/personalCollection";
    }

    @GetMapping("user/{userid}")
    public String user(@PathVariable("userid") String userid,Model model)
    {
        List<Post> list = loginServcie.userPost(userid);
        model.addAttribute("listPost",list);
        List<UserAction> userActions = loginServcie.userAction(userid);
        model.addAttribute("userActions",userActions);
        return "/personal/personalcenter";
    }


    @GetMapping("personalSettings")
    public String personalSettings(Model model)
    {
        return "/personal/personalSettings";
    }

    @GetMapping("personalInformation")
    public String personalInformation(Model model,HttpServletRequest req,Integer pn)
    {
        PageInfo pageInfo = loginServcie.personalInformation(req,pn);
        model.addAttribute("pageInfo",pageInfo);
        return "/personal/personalInformation";
    }


    @PostMapping("doSetting")
    @ResponseBody
    public String doSetting(User user,HttpServletRequest req)
    {
        loginServcie.updateDoSetting(user,req);
        return "";
    }


    @PostMapping("uploadUserImg")
    @ResponseBody
    public Map<String,Object> uploadUserImg(HttpServletRequest req, MultipartFile file)
    {
        String uploadYy = SpringMvcUpload.uploadYy(req, file, "static/uploadImage");
        loginServcie.updateUserImg(req,"/static/uploadImage/"+uploadYy);
        Map<String,Object> map = new HashMap<>();
        map.put("src","/static/uploadImage/"+uploadYy);
        return map;
    }


    @PostMapping(value="resetpwd",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String resetpwd(String nowpassword,String password,String repassword,HttpServletRequest req)
    {
        return loginServcie.updateUserPassword(nowpassword,password,repassword,req);
    }


    @GetMapping("messageDel/{messageId}")
    public String messageDel(@PathVariable("messageId")String messageId,Integer pn,Integer total,Integer pageSize)
    {
        loginServcie.deleteMessage(messageId);
        if((total-1)%pageSize==0) {pn-=1;}
        return "redirect:/role/personalInformation?pn="+pn;
    }

    @GetMapping("deleteAllMessage")
    public String deleteAllMessage(HttpServletRequest req)
    {
        loginServcie.deleteAllMessage(req);
        return "redirect:/role/personalInformation";
    }

    @GetMapping("personalActivation")
    public String personalActivation()
    {
        return "/personal/personalActivation";
    }

    @GetMapping("logout")
    public String logout()
    {
        Subject currentUser = SecurityUtils.getSubject();
        //会将shiro-session和session  都清空 非常好使
        currentUser.logout();
        return "redirect:/";
    }


    @PostMapping("todaySign")
    @ResponseBody
    public String todaySign(HttpServletRequest req)
    {
        String certification = loginServcie.certification(req);
        if(certification.equals("1"))
        {
            UserAction userAction = new UserAction();
            loginServcie.insertCertification(req,userAction);
        }
        return certification;
    }



}
