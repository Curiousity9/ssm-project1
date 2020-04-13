package com.ay.model;

import java.io.Serializable;

/**
 * @author xiangwehao
 * create 2020/4/7
 */
public class User implements Serializable {
    private String id;
    private String name;
    private String account;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
