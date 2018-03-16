package com.jk.service;

import com.jk.entity.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginServcie {

    String doLogin(String email, String password, String vercode, HttpServletRequest req);

    List<Post> getAll(Integer status,Model model,Integer pn,Integer recommend,String category_id);

    String insertUser(User user, String vercode,HttpServletRequest req);

    Post tiziXq(String postid,HttpServletRequest req,Model model);

    List<Comment> listComment(String postid,Integer pn);

    void insertHuiFu(String content,String to_id,String id,HttpServletRequest req);

    void updatePostTure(Post post);

    void insertPostTure(Post post,HttpServletRequest req);

    String updateAdopt(String postid, String commentid,HttpServletRequest req,Long pay_point,String commentid_user);

    void insertCollection(String postid,HttpServletRequest req,String posttitle);

    void deleteCollection(String postid,HttpServletRequest req,String posttitle);

    void operationFore(Integer state, String postid);

    List<Post> userPost(String userid);

    List<UserAction> userAction(String userid);

    void updateDoSetting(User user,HttpServletRequest req);

    void updateUserImg(HttpServletRequest req, String s);

    String updateUserPassword(String nowpassword, String password,String repassword, HttpServletRequest req);

    PageInfo personalPost(Model model, HttpServletRequest request, Integer pn);

    PageInfo collectionPost(HttpServletRequest request, Integer pn);

    PageInfo personalInformation(HttpServletRequest req,Integer pn);

    void deleteMessage(String messageId);

    void deleteAllMessage(HttpServletRequest req);

    String certification(HttpServletRequest req);

    void insertCertification(HttpServletRequest req, UserAction userAction);

    void updateIntegral(HttpServletRequest req,Integer integral);

}
