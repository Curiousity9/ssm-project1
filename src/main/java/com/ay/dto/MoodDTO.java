package com.ay.dto;

import com.ay.model.Mood;

/**
 * @author xiangwehao
 * create 2020/4/7
 */
public class MoodDTO extends Mood {
    private String username;
    private String userAccount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
