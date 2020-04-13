package com.ay.service;

import com.ay.dto.UserDTO;

/**
 * @author xiangwehao
 * create 2020/4/7
 */
public interface UserService {
    UserDTO find(String id);
}
