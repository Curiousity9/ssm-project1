package com.ay.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * xwh
 * 2020/03/27
 */
public class AyUser implements Serializable {
    private String id;
//    @NotBlank(message = "name不为空")
    private String name;
//    @Length(min = 3,max = 16,message = "密码长度3~16")
    private String password;
//    @Range(min = 0,max = 100,message = "年龄不达标")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
