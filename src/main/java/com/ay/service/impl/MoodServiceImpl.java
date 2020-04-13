package com.ay.service.impl;

import com.ay.dao.MoodDao;
import com.ay.dao.UserDao;
import com.ay.dao.UserMoodPraiseRelDao;
import com.ay.dto.MoodDTO;
import com.ay.model.Mood;
import com.ay.model.User;
import com.ay.model.UserMoodPraiseRel;
import com.ay.service.MoodService;
import com.ay.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiangwehao
 * create 2020/4/8
 */
@Service
public class MoodServiceImpl implements MoodService {
    @Resource
    private MoodDao moodDao;
    @Resource
    private UserDao userDao;
    @Resource
    private UserMoodPraiseRelDao userMoodPraiseRelDao;

    public List<MoodDTO> findAll() {
         //查询所有说说
        List<Mood> moodList = moodDao.findAll();
        return converModel122DTO(moodList);
    }

    public boolean praisedMood(String userId,String moodId){
        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
        userMoodPraiseRel.setUserId(userId);
        userMoodPraiseRel.setMoodId(moodId);
        System.out.println("MoodeServiceImpl : userId = "+userId+"  moodId  = "+moodId);
        userMoodPraiseRelDao.save(userMoodPraiseRel);
        Mood mood=this.findById(moodId);
        mood.setPriseNum(mood.getPriseNum() + 1);
        this.update(mood);
        return Boolean.TRUE;
    }
    public Mood findById(String id) {
        return moodDao.findById(id);
    }

    //跟新说说数据
    public boolean update(Mood mood) {
        return moodDao.update(mood);
    }
    //DTO赋值
    private List<MoodDTO> converModel122DTO(List<Mood> moodList){
        if(CollectionUtils.isEmpty(moodList))
            return Collections.EMPTY_LIST;
        List<MoodDTO> moodDTOList = new ArrayList<>();
        for(Mood mood:moodList){
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setId(mood.getId());
            moodDTO.setContent(mood.getContent());
            moodDTO.setPriseNum(mood.getPriseNum());
            moodDTO.setPublishTime(mood.getPublishTime());
            moodDTO.setUserId(mood.getUserId());
            moodDTOList.add(moodDTO);
            //设置用户信息
            User user = userDao.find(mood.getUserId());
            moodDTO.setUsername(user.getName());
            moodDTO.setUserAccount(user.getAccount());

        }
        return moodDTOList;
    }

    @Resource
    private RedisTemplate redisTemplate;
    //key命名规范 ： 项目名称+模块名称+具体内容
    private static final String PRAISE_HASH_KEY ="springmv.mybatis.boot.mood.id.list.key";


    public boolean praiseMoodForRedis(String userId, String moodId) {
        redisTemplate.opsForSet().add(PRAISE_HASH_KEY,moodId);
        redisTemplate.opsForSet().add(moodId,userId);
        return false;
    }


    @Resource
    private UserService userService;

    public List<MoodDTO> findAllForRedis() {
        List<Mood> moodList = moodDao.findAll();
        if(CollectionUtils.isEmpty(moodList)){
            return Collections.EMPTY_LIST;
        }
        List<MoodDTO> moodDTOList = new ArrayList<>();
        for(Mood mood: moodList){
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setId(mood.getId());
            moodDTO.setUserId(mood.getUserId());
            moodDTO.setPriseNum(mood.getPriseNum() + redisTemplate.opsForSet().size(mood.getId()).intValue());
            moodDTO.setPublishTime(mood.getPublishTime());
            moodDTO.setContent(mood.getContent());
            User user = userService.find(mood.getUserId());
            moodDTO.setUsername(user.getName());
            moodDTO.setUserAccount(user.getAccount());
            moodDTOList.add(moodDTO);
        }
        return moodDTOList;
    }
}
