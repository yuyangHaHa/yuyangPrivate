package com.jk.mapper;

import com.jk.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {
    List<User> doLogin(String email);

    List<Post> zhiDing(@Param(value="category_id")String category_id);

    List<Post> getAll(@Param(value="status")Integer status,@Param(value="recommend")Integer recommend,@Param(value="category_id")String category_id);

    void insertUser(User user);

    Post tiziXq(String postid);

    List<Comment> listComment(String postid);

    void insertHuiFu(Comment comment);

    void updatePostTure(@Param(value="post")Post post);

    void insertPostTure(Post post);

    Post judgeToAdopt(String postid);

    void updatePostAdopt(String postid);

    void updateCommentAdopt(String commentid);

    UserCollection userCollectionCollection(String postid, String id);

    void insertCollection(UserCollection userCollection);

    void deleteCollection(String postid, String id);

    void deleteCollectionPost(String postid);

    void deleteCollectionComment(String postid);

    void updatePost(String postid,Integer state);

    void updatePostTop(String postid);

    void updatePostEssence(String postid);

    void updatePostCancelEssence(String postid);

    void insertUserAction(UserAction userAction);

    List<Post> userPost(String userid);

    List<UserAction> userAction(String userid);

    void updateDoSetting(User user);

    void updateUserImg(String id, String s);

    void updateUserPassword(String id, String password1);

    List<Post> personalPost(String userid);

    List<UserCollection> collectionPost(String id);

    List<UserMessage> personalInformation(String id);

    void insertUserMessage(UserMessage userMessage);

    void deleteMessage(String messageId);

    void deleteAllMessage(String id);

    UserAction certification(String id);

    void insertCertification(UserAction userAction);

    void updateIntegral(String id, Integer integral);

    void insertUserOnline(UserOnline online);
}
