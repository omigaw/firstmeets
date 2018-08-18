package com.firstmeetschool.school.service;

import com.firstmeetschool.school.entity.User;
import com.firstmeetschool.school.mapper.InsertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class InsertService {

    @Autowired
    private InsertMapper insertMapper;




    public int insertUserInfo(String usrWechat, String usrName, String usrTelephone, String usrHeight, String usrAge,
                            String homeTown, String currentCity, String usrSex, String usrEducatioin, String isStudent ){
        int newUser = this.insertMapper.insertUser(usrWechat, usrName, usrTelephone, usrHeight, usrAge,
                                                   homeTown, currentCity, usrSex, usrEducatioin,isStudent);
        return newUser;
    }

//    public int insertUserInfo(){
//        int newUser = this.insertMapper.insertUser("onetwothree123", "cc", "17745812348", "1.90",
//        "27", "台湾", "北京", "male", "博士", "no");
//        return newUser;
//    }
}
