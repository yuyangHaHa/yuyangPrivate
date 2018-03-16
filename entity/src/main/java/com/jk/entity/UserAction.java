package com.jk.entity;


import java.util.Date;

public class UserAction {

  private String id;
  private String user_id;
  private String action;
  private long point;
  private String post_id;
  private String comment_id;
  private Date created;
  private Date modified;

  //--
  private Post ps;
  private Comment cm;

  @Override
  public String toString() {
    return "UserAction{" +
            "id='" + id + '\'' +
            ", user_id='" + user_id + '\'' +
            ", action='" + action + '\'' +
            ", point=" + point +
            ", post_id='" + post_id + '\'' +
            ", comment_id='" + comment_id + '\'' +
            ", created=" + created +
            ", modified=" + modified +
            ", ps=" + ps +
            ", cm=" + cm +
            '}';
  }

  public Post getPs() {
    return ps;
  }

  public void setPs(Post ps) {
    this.ps = ps;
  }

  public Comment getCm() {
    return cm;
  }

  public void setCm(Comment cm) {
    this.cm = cm;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public long getPoint() {
    return point;
  }

  public void setPoint(long point) {
    this.point = point;
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
}
