package com.ay.dao;

import com.ay.model.Mood;
import com.ay.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiangwehao
 * create 2020/4/7
 */
@Repository
public interface MoodDao  {
    List<Mood> findAll();
    Mood findById(String id);
    boolean update(@Param("mood")Mood mood);
}
