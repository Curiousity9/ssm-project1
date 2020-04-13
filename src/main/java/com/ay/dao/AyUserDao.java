package com.ay.dao;

import com.ay.model.AyUser;
import com.ay.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AyUserDao {
    List<AyUser> findAll();
 //    int insert(AyUser ayUser);
//    AyUser findByid(String pas. sword);
}
