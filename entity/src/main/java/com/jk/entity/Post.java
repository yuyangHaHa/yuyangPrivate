package com.jk.entity;


import java.util.Date;

public class Post {

  private String id;
  private String title;
  private String content;
  private String edit_mode;
  private String category_id;
  private String user_id;
  private String user_ip;
  private String user_agent;
  private long vote_up;
  private long vote_down;
  private double price;
  private long pay_point;
  private String comment_status;
  private long comment_count;
  private Date comment_time;
  private long view_count;
  private long recommend;
  private long level;
  private long status;
  private Date created;
  private Date modified;

  //-------------
  private User user;
  private Category category;


  @Override
  public String toString() {
    return "Post{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", edit_mode='" + edit_mode + '\'' +
            ", category_id='" + category_id + '\'' +
            ", user_id='" + user_id + '\'' +
            ", user_ip='" + user_ip + '\'' +
            ", user_agent='" + user_agent + '\'' +
            ", vote_up=" + vote_up +
            ", vote_down=" + vote_down +
            ", price=" + price +
            ", pay_point=" + pay_point +
            ", comment_status='" + comment_status + '\'' +
            ", comment_count=" + comment_count +
            ", comment_time=" + comment_time +
            ", view_count=" + view_count +
            ", recommend=" + recommend +
            ", level=" + level +
            ", status=" + status +
            ", created=" + created +
            ", modified=" + modified +
            ", user=" + user +
            ", category=" + category +
            '}';
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getEdit_mode() {
    return edit_mode;
  }

  public void setEdit_mode(String edit_mode) {
    this.edit_mode = edit_mode;
  }

  public String getCategory_id() {
    return category_id;
  }

  public void setCategory_id(String category_id) {
    this.category_id = category_id;
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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public long getPay_point() {
    return pay_point;
  }

  public void setPay_point(long pay_point) {
    this.pay_point = pay_point;
  }

  public String getComment_status() {
    return comment_status;
  }

  public void setComment_status(String comment_status) {
    this.comment_status = comment_status;
  }

  public long getComment_count() {
    return comment_count;
  }

  public void setComment_count(long comment_count) {
    this.comment_count = comment_count;
  }

  public Date getComment_time() {
    return comment_time;
  }

  public void setComment_time(Date comment_time) {
    this.comment_time = comment_time;
  }

  public long getView_count() {
    return view_count;
  }

  public void setView_count(long view_count) {
    this.view_count = view_count;
  }

  public long getRecommend() {
    return recommend;
  }

  public void setRecommend(long recommend) {
    this.recommend = recommend;
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
