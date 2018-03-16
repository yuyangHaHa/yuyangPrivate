package com.jk.entity;


import java.util.Date;

public class Comment {

  private String id;
  private String content;
  private String parent_id;
  private String post_id;
  private String user_id;
  private String user_ip;
  private String user_agent;
  private long vote_up;
  private long vote_down;
  private long level;
  private long status;
  private Date created;
  private Date modified;

  //----------
  private String nickname;
  private String avatar;

  @Override
  public String toString() {
    return "Comment{" +
            "id='" + id + '\'' +
            ", content='" + content + '\'' +
            ", parent_id='" + parent_id + '\'' +
            ", post_id='" + post_id + '\'' +
            ", user_id='" + user_id + '\'' +
            ", user_ip='" + user_ip + '\'' +
            ", user_agent='" + user_agent + '\'' +
            ", vote_up=" + vote_up +
            ", vote_down=" + vote_down +
            ", level=" + level +
            ", status=" + status +
            ", created=" + created +
            ", modified=" + modified +
            ", nickname='" + nickname + '\'' +
            ", avatar='" + avatar + '\'' +
            '}';
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getParent_id() {
    return parent_id;
  }

  public void setParent_id(String parent_id) {
    this.parent_id = parent_id;
  }

  public String getPost_id() {
    return post_id;
  }

  public void setPost_id(String post_id) {
    this.post_id = post_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getUser_ip() {
    return user_ip;
  }

  public void setUser_ip(String user_ip) {
    this.user_ip = user_ip;
  }

  public String getUser_agent() {
    return user_agent;
  }

  public void setUser_agent(String user_agent) {
    this.user_agent = user_agent;
  }

  public long getVote_up() {
    return vote_up;
  }

  public void setVote_up(long vote_up) {
    this.vote_up = vote_up;
  }

  public long getVote_down() {
    return vote_down;
  }

  public void setVote_down(long vote_down) {
    this.vote_down = vote_down;
  }

  public long getLevel() {
    return level;
  }

  public void setLevel(long level) {
    this.level = level;
  }

  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
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

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
}
