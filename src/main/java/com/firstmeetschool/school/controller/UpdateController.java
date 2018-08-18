package com.firstmeetschool.school.controller;

import com.firstmeetschool.school.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * @function: update user info.
 * @author:xym
 * @ 21st, July, 2018
 */

@RestController
public class UpdateController {

    @Autowired
    private UpdateService updateService;

    @RequestMapping(value = "/{usrId}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String updateUserInfo(@PathVariable("usrId") Integer usrId, @RequestParam(value = "usrWechat") String usrWechat,
    @RequestParam(value = "usrName") String usrName, @RequestParam("usrTelephone") String usrTelephone,
    @RequestParam("usrHeight") String usrHeight, @RequestParam("usrAge") String usrAge, @RequestParam("homeTown") String homeTown,
    @RequestParam("currentCity") String currentCity, @RequestParam("usrSex") String usrSex,
    @RequestParam("usrEducation") String usrEducation, @RequestParam("isStudent") String isStudent){



        int temp = updateService.updateUserInfo(usrId,usrWechat, usrName, usrTelephone, usrHeight, usrAge,
                                                homeTown, currentCity, usrSex, usrEducation,isStudent);

        if (1==temp){
            return "success.";
        }else {
            return "fail.";
        }
    }
}
