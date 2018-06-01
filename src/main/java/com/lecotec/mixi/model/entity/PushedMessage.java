package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mx_pushed_message")
public class PushedMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    private String title;

    private String content;

    private String userTypePushed;

    private String publishUser;

    @ApiModelProperty(hidden = true)
    private Date creationTime = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getUserTypePushed() {
        return userTypePushed;
    }

    public void setUserTypePushed(String userTypePushed) {
        this.userTypePushed = userTypePushed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
