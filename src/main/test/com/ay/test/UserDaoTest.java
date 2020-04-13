package com.ay.test;

import com.ay.dao.AyUserDao;
import com.ay.model.AyUser;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiangwehao
 * create 2020/3/30
 */
public class UserDaoTest {
    @Resource
    private AyUserDao ayUserDao;

    @Test
    public void testFindAll(){
        List<AyUser> ayUserList= ayUserDao.findAll();
        System.out.println(ayUserList.size());
    }
}
