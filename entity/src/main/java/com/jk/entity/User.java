package com.jk.entity;


import java.util.Date;

public class User {

  private String id;
  private String nickname;
  private String password;
  private String salt;
  private String role;
  private String email;
  private long email_status;
  private String mobile;
  private long mobile_status;
  private long point;
  private String title;
  private String auth_info;
  private String gender;
  private String signature;
  private long post_count;
  private long comment_count;
  private String wechat;
  private String weibo;
  private Date birthday;
  private String company;
  private String address;
  private String site;
  private String avatar;
  private long status;
  private Date created;
  private String create_source;
  private Date modified;
  private Date logged;
  private Date activated;

  @Override
  public String toString() {
    return "User{" +
            "id='" + id + '\'' +
            ", nickname='" + nickname + '\'' +
            ", password='" + password + '\'' +
            ", salt='" + salt + '\'' +
            ", role='" + role + '\'' +
            ", email='" + email + '\'' +
            ", email_status=" + email_status +
            ", mobile='" + mobile + '\'' +
            ", mobile_status=" + mobile_status +
            ", point=" + point +
            ", title='" + title + '\'' +
            ", auth_info='" + auth_info + '\'' +
            ", gender='" + gender + '\'' +
            ", signature='" + signature + '\'' +
            ", post_count=" + post_count +
            ", comment_count=" + comment_count +
            ", wechat='" + wechat + '\'' +
            ", weibo='" + weibo + '\'' +
            ", birthday=" + birthday +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", site='" + site + '\'' +
            ", avatar='" + avatar + '\'' +
            ", status=" + status +
            ", created=" + created +
            ", create_source='" + create_source + '\'' +
            ", modified=" + modified +
            ", logged=" + logged +
            ", activated=" + activated +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getEmail_status() {
    return email_status;
  }

  public void setEmail_status(long email_status) {
    this.email_status = email_status;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public long getMobile_status() {
    return mobile_status;
  }

  public void setMobile_status(long mobile_status) {
    this.mobile_status = mobile_status;
  }

  public long getPoint() {
    return point;
  }

  public void setPoint(long point) {
    this.point = point;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuth_info() {
    return auth_info;
  }

  public void setAuth_info(String auth_info) {
    this.auth_info = auth_info;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public long getPost_count() {
    return post_count;
  }

  public void setPost_count(long post_count) {
    this.post_count = post_count;
  }

  public long getComment_count() {
    return comment_count;
  }

  public void setComment_count(long comment_count) {
    this.comment_count = comment_count;
  }

  public String getWechat() {
    return wechat;
  }

  public void setWechat(String wechat) {
    this.wechat = wechat;
  }

  public String getWeibo() {
    return weibo;
  }

  public void setWeibo(String weibo) {
    this.weibo = weibo;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
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

  public String getCreate_source() {
    return create_source;
  }

  public void setCreate_source(String create_source) {
    this.create_source = create_source;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public Date getLogged() {
    return logged;
  }

  public void setLogged(Date logged) {
    this.logged = logged;
  }

  public Date getActivated() {
    return activated;
  }

  public void setActivated(Date activated) {
    this.activated = activated;
  }
}
