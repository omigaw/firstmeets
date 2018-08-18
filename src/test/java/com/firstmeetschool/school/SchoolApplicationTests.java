package com.firstmeetschool.school;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
    }


    @Test
    public void T() throws Exception{
        stringRedisTemplate.opsForValue().set("aac","21");
        Assert.assertEquals("21",stringRedisTemplate.opsForValue().get("aac"));
    }

}
