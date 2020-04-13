package com.ay.job;

import com.ay.model.Mood;
import com.ay.model.UserMoodPraiseRel;
import com.ay.service.MoodService;
import com.ay.service.UserMoodPraiseRelService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Set;

/**
 * @author xiangwehao
 * create 2020/4/11
 */
@Component
@Configurable
@EnableScheduling
public class praiseDataSaveDBJob {
    @Resource
    private RedisTemplate redisTemplate;
    private static final String PRAISE_HASH_KEY ="springmv.mybatis.boot.mood.id.list.key";
    @Resource
    private UserMoodPraiseRelService userMoodPraiseRelService;
    @Resource
    private MoodService moodService;

    @Scheduled(cron = "*/1 * *  * * * ")
    public void savePraiseDataToDB2() {

        //1.在redis缓存所有的被点赞说说id
        Set<String> moods = redisTemplate.opsForSet().members(PRAISE_HASH_KEY);
        if(CollectionUtils.isEmpty(moods)){
            return ;
        }
        System.out.println("moods.size()= " + moods.size());
        for(String moodId:moods){
            if(redisTemplate.opsForSet().members(moodId) == null){
                continue;
            }else {

                //2.通过说说id获得点赞用户id
                Set<String> userIds = redisTemplate.opsForSet().members(moodId);
                if(CollectionUtils.isEmpty(userIds)){
                    System.out.println("userId == kong");
                    continue;
                }
                else {
                    System.out.println("userId.size() = " + userIds.size());
                    //3.将id存入MySql
                    int a=0;
                    for(String userId : userIds){
                        a++;
                        System.out.println("a = "+ a +"   userId = " + userId);
                        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
                        userMoodPraiseRel.setUserId(userId);
                        userMoodPraiseRel.setMoodId(moodId);
//                        moodService.praisedMood(userId, moodId);有用

                        userMoodPraiseRelService.save(userMoodPraiseRel);
                    }
                    Mood mood = moodService.findById(moodId);
                    //4.更新点赞数量
//                    redisTemplate.opsForSet().move();
                    System.out.println("更新点赞数量");
                    mood.setPriseNum(mood.getPriseNum() + redisTemplate.opsForSet().size(moodId).intValue());
                    moodService.update(mood);
                    //5.清除缓存
                    moods.remove(moodId);
                    redisTemplate.delete(moodId);

                }
            }
         }////////////
        //6.清楚redis的缓存数据
        redisTemplate.delete(PRAISE_HASH_KEY);
    }
}
