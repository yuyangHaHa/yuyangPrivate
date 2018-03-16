package com.jk.entity;


import java.sql.Timestamp;
import java.util.Date;

public class UserCollection {

  private String id;
  private String user_id;
  private String post_id;
  private String post_title;
  private String post_content;
  private String post_user_id;
  private Date created;
  private Date modified;

  @Override
  public String toString() {
    return "UserCollection{" +
            "id='" + id + '\'' +
            ", user_id='" + user_id + '\'' +
            ", post_id='" + post_id + '\'' +
            ", post_title='" + post_title + '\'' +
            ", post_content='" + post_content + '\'' +
            ", post_user_id='" + post_user_id + '\'' +
            ", created=" + created +
            ", modified=" + modified +
            '}';
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

  public String getPost_id() {
    return post_id;
  }

  public void setPost_id(String post_id) {
    this.post_id = post_id;
  }

  public String getPost_title() {
    return post_title;
  }

  public void setPost_title(String post_title) {
    this.post_title = post_title;
  }

  public String getPost_content() {
    return post_content;
  }

  public void setPost_content(String post_content) {
    this.post_content = post_content;
  }

  public String getPost_user_id() {
    return post_user_id;
  }

  public void setPost_user_id(String post_user_id) {
    this.post_user_id = post_user_id;
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
