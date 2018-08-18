package com.firstmeetschool.school.controller;


import com.firstmeetschool.school.service.LoginService;
import com.github.kevinsawicki.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;


    /*接口url
    "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code"
    */
    @RequestMapping("/login_code/{code}/{state}")
    public  String login(@PathVariable("code") String code,@PathVariable("state") String state){

        String result=loginService.logincode(code,state);

        return result;

    }
}
