package com.ay.service.impl;

import com.ay.dao.UserMoodPraiseRelDao;
import com.ay.model.UserMoodPraiseRel;
import com.ay.service.UserMoodPraiseRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiangwehao
 * create 2020/4/8
 */
@Service
public class UserMoodPraiseRelServiceImpl implements UserMoodPraiseRelService {
    @Resource
    private UserMoodPraiseRelDao userMoodPraiseRelDao;


    public boolean save(UserMoodPraiseRel userMoodPraiseRel) {
//        System.out.println("your mather fly"+"userId="+userMoodPraiseRel.getUserId()+"   moodId="+
//                userMoodPraiseRel.getMoodId());
        return userMoodPraiseRelDao.save(userMoodPraiseRel);
    }
}
