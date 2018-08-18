package com.firstmeetschool.school.controller;

import com.firstmeetschool.school.entity.User;
import com.firstmeetschool.school.service.InsertService;
import com.firstmeetschool.school.utils.CollectUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @function: insert new user info.
 * @author:xym
 * @ 21st, July, 2018
 */

@RestController
public class InsertController {

    @Autowired
    private InsertService insertService;

//    @RequestMapping( value = "/insert", method = RequestMethod.GET)
//    public String insertNewUser(){
//        int newUser = insertService.insertUserInfo();
//        CollectUserInfo tempUser = new CollectUserInfo();
//        String res = tempUser.collectUserInfo(newUser);
//
//        if(newUser == 1) {
//            return res;
//        }else{
//            return "fail";
//        }
//    }

    @RequestMapping( value = "/insert", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String postNewUser(@RequestParam(value = "usrWechat") String usrWechat, @RequestParam(value = "usrName") String usrName,
    @RequestParam("usrTelephone") String usrTelephone, @RequestParam("usrHeight") String usrHeight, @RequestParam("usrAge") String usrAge,
    @RequestParam("homeTown") String homeTown, @RequestParam("currentCity") String currentCity, @RequestParam("usrSex") String usrSex,
    @RequestParam("usrEducation") String usrEducation, @RequestParam("isStudent") String isStudent){
        int t = insertService.insertUserInfo(usrWechat, usrName, usrTelephone, usrHeight, usrAge,
                                             homeTown, currentCity, usrSex, usrEducation, isStudent);
        if(1==t){
            return "success";
        }else{
            return "fail";
        }
    }


}
