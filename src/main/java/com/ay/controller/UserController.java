package com.ay.controller;

import com.ay.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户控制层
 * @author xiangwehao
 * create 2020/4/8
 */
@RestController
@RequestMapping("/user1")
public class UserController {
    @Resource
    private UserService userService;

}
