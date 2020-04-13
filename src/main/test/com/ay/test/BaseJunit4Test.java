package com.ay.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author xiangwehao
 * create 2020/4/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml",
                                    "classpath*:spring-mvc.xml",
                                    "classpath*:spring-redis.xml"})
public class BaseJunit4Test {
}
