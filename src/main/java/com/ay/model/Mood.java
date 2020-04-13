package com.ay.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiangwehao
 * create 2020/4/7
 */
public class Mood implements Serializable {
    private String id;//主键
    private String content;
    private Integer priseNum;
    private String userId;
    private Date publishTime;

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

    public Integer getPriseNum() {
        return priseNum;
    }

    public void setPriseNum(Integer priseNum) {
        this.priseNum = priseNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
