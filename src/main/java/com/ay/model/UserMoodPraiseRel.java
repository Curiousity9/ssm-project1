package com.ay.model;

import java.io.Serializable;

/**
 * @author xiangwehao
 * create 2020/4/7
 */
public class UserMoodPraiseRel implements Serializable {
    private String id;
    private String userId;
    private String moodId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMoodId() {
        return moodId;
    }

    public void setMoodId(String moodId) {
        this.moodId = moodId;
    }
}
