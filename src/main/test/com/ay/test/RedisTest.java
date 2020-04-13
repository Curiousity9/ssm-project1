package com.ay.test;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author xiangwehao
 * create 2020/4/10
 */

public class RedisTest extends BaseJunit4Test   {
    @Resource
    private RedisTemplate  redisTemplate;
    @Test
    public  void testRedis(){
          redisTemplate.opsForValue().set("name","xwh");
        System.out.println(redisTemplate.opsForValue().get("name"));
//        redisTemplate.opsForValue().f
    }
}