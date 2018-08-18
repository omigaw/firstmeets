package com.firstmeetschool.school.service;

import com.firstmeetschool.school.mapper.UpdateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {

    @Autowired
    private UpdateMapper updateMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger LOGGER=LoggerFactory.getLogger(UpdateService.class);

    public int updateUserInfo(Integer usrId,String usrWechat, String usrName, String usrTelephone, String usrHeight, String usrAge,
                              String homeTown, String currentCity, String usrSex, String usrEducatioin, String isStudent ){

        /**
         * 更新用户逻辑：
         * 如果缓存存在，删除
         * 如果缓存不存在，不操作
         */

        String key = "User_"+usrId;
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            redisTemplate.delete(key);
            LOGGER.info("从缓存中删除用户"+usrId);
        }

        int newUser = this.updateMapper.updateUser(usrWechat, usrName, usrTelephone, usrHeight, usrAge,
                homeTown, currentCity, usrSex, usrEducatioin,isStudent);
        return newUser;
    }
}
