package com.jk.entity;


import java.util.Date;

public class Category {

  private String id;
  private String name;
  private String content;
  private String summary;
  private String icon;
  private long post_count;
  private long order_number;
  private long parent_id;
  private String meta_keywords;
  private String meta_description;
  private Date created;
  private Date modified;

  @Override
  public String toString() {
    return "Category{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", content='" + content + '\'' +
            ", summary='" + summary + '\'' +
            ", icon='" + icon + '\'' +
            ", post_count=" + post_count +
            ", order_number=" + order_number +
            ", parent_id=" + parent_id +
            ", meta_keywords='" + meta_keywords + '\'' +
            ", meta_description='" + meta_description + '\'' +
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public long getPost_count() {
    return post_count;
  }

  public void setPost_count(long post_count) {
    this.post_count = post_count;
  }

  public long getOrder_number() {
    return order_number;
  }

  public void setOrder_number(long order_number) {
    this.order_number = order_number;
  }

  public long getParent_id() {
    return parent_id;
  }

  public void setParent_id(long parent_id) {
    this.parent_id = parent_id;
  }

  public String getMeta_keywords() {
    return meta_keywords;
  }

  public void setMeta_keywords(String meta_keywords) {
    this.meta_keywords = meta_keywords;
  }

  public String getMeta_description() {
    return meta_description;
  }

  public void setMeta_description(String meta_description) {
    this.meta_description = meta_description;
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
