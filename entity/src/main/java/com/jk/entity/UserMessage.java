package com.jk.entity;


import java.sql.Timestamp;
import java.util.Date;

public class UserMessage {

  private String id;
  private String from_user_id;
  private String to_user_id;
  private String post_id;
  private String comment_id;
  private String action;
  private String content;
  private long type;
  private Date created;
  private Date modified;

  //--------
  private User us;
  private Post ps;
  private String timeDifferencel;

  //----------


  @Override
  public String toString() {
    return "UserMessage{" +
            "id='" + id + '\'' +
            ", from_user_id='" + from_user_id + '\'' +
            ", to_user_id='" + to_user_id + '\'' +
            ", post_id='" + post_id + '\'' +
            ", comment_id='" + comment_id + '\'' +
            ", action='" + action + '\'' +
            ", content='" + content + '\'' +
            ", type=" + type +
            ", created=" + created +
            ", modified=" + modified +
            ", us=" + us +
            ", ps=" + ps +
            ", timeDifferencel='" + timeDifferencel + '\'' +
            '}';
  }

  public String getTimeDifferencel() {
    return timeDifferencel;
  }

  public void setTimeDifferencel(String timeDifferencel) {
    this.timeDifferencel = timeDifferencel;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFrom_user_id() {
    return from_user_id;
  }

  public void setFrom_user_id(String from_user_id) {
    this.from_user_id = from_user_id;
  }

  public String getTo_user_id() {
    return to_user_id;
  }

  public void setTo_user_id(String to_user_id) {
    this.to_user_id = to_user_id;
  }

  public String getPost_id() {
    return post_id;
  }

  public void setPost_id(String post_id) {
    this.post_id = post_id;
  }

  public String getComment_id() {
    return comment_id;
  }

  public void setComment_id(String comment_id) {
    this.comment_id = comment_id;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public User getUs() {
    return us;
  }

  public void setUs(User us) {
    this.us = us;
  }

  public Post getPs() {
    return ps;
  }

  public void setPs(Post ps) {
    this.ps = ps;
  }
}
