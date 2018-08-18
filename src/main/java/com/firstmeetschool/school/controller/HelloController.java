package com.firstmeetschool.school.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * @function: test controller.
 */

@RestController
public class HelloController {


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "hello! world";
    }


}
