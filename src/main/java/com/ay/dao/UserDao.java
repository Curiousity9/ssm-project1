package com.ay.dao;

import com.ay.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author xiangwehao
 * create 2020/4/7
 */
@Repository
public interface UserDao {
    //不知道在干吗
      User find(String id);
}
