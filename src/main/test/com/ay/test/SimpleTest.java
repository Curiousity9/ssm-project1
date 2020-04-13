package com.ay.test;

import org.junit.Test;

/**
 * @author xiangwehao
 * create 2020/4/1
 */
public class SimpleTest {
    @Test
    public void testMax(){
        int x=Math.min(6,10);
        assert  (x>=5 && x<=10);
    }
}
