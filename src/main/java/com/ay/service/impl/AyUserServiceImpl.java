package com.ay.service.impl;

import com.ay.dao.AyUserDao;
import com.ay.model.AyUser;
import com.ay.service.AyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiangwehao
 * create 2020/3/27
 */
@Service
public class AyUserServiceImpl implements AyUserService {
    @Resource
    private AyUserDao ayUserDao;
    public List<AyUser> findAll(){
        return ayUserDao.findAll();
    }
//    public String insert(AyUser ayUser){
//        return ayUser.getId();
//    }
//    public AyUser findByid(String password){
//        return ayUserDao.findByid(password);
//    }
}
