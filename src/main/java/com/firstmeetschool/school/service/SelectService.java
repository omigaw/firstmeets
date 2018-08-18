package com.firstmeetschool.school.service;

import com.firstmeetschool.school.mapper.SelectMapper;
import com.firstmeetschool.school.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SelectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectService.class);

    @Autowired
    private SelectMapper selectMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 查找用户逻辑：
     * 缓存中有用户就直接从缓存中取
     * 缓存中没有从数据库取
     * @param usrId
     * @return
     */

    public User getUserById(Integer usrId){
        String key = "User_"+usrId;
        ValueOperations<String,User> operations=redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);

        if(hasKey){
            User user = operations.get(key);
            LOGGER.info("从缓存中获取了一个有id的用户信息"+user.toString());
            return user;
        }
        User user = this.selectMapper.findUserById(usrId);
        operations.set(key,user,100,TimeUnit.SECONDS);
        LOGGER.info("一个带有id的用户插入缓存"+user.toString());
        return user;
    }

    public List<User> getAllUsersInfo(){
        String key = "allUser_";
        ListOperations<String,User> operations=redisTemplate.opsForList();

        boolean hasKey = redisTemplate.hasKey(key);

        if(hasKey){
            List<User> user = operations.range(key,0,-1);
            LOGGER.info("从缓存中获取所有用户信息"+user.toString());
            return user;
        }
        List<User> users = this.selectMapper.findAllUsersList();
        operations.rightPushAll(key,users);
        LOGGER.info("所有用户信息插入缓存");
        return users;
    }

    public List<User> getUsersByName(String usrName){
        List<User> users = this.selectMapper.findUserByName(usrName);
        return users;
    }

    public List<User> getFilterHomePage(){
        String key = "filteruser_";
        ListOperations<String,User> operations= redisTemplate.opsForList();

        boolean hasKey = redisTemplate.hasKey(key);

        if(hasKey){
            List<User> user = operations.range(key,0,-1);
            LOGGER.info("从缓存中获取过滤用户信息"+user.toString());
            return user;
        }
        List<User> filterUsers = this.selectMapper.filterHomePage("female", "本科", "yes");
        operations.rightPushAll(key,filterUsers);
        LOGGER.info("过滤用户信息插入缓存"+filterUsers.toString());
        return filterUsers;
    }
}
