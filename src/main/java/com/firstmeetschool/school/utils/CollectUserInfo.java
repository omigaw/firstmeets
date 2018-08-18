package com.firstmeetschool.school.utils;

import com.firstmeetschool.school.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class CollectUserInfo {

    private List<User> users;
    private User user;

    public void setUserList(List<User> users){
        this.users = users;
    }

    public List<User> getUserList(){
        return users;
    }

    public void setUser(User user) {this.user = user;}

    public User getUser() {return user;}

    public String collectUserListInfo(List<User> users) {

        JSONArray resArray = new JSONArray();
        for (User usr : users) {
            JSONObject temp = new JSONObject();
            temp.put("userId", usr.getUsrId());
            temp.put("userName", usr.getUsrName());
            temp.put("userWechat", usr.getUsrWechat());
            temp.put("usrTelephone", usr.getUsrTelephone());
            temp.put("usrSex", usr.getUsrSex());
            temp.put("usrHeight", usr.getUsrHeight());
            temp.put("usrAge", usr.getUsrAge());
            temp.put("usrHobby", usr.getUsrHobby());
            temp.put("birthDay", usr.getBirthDay());
            temp.put("homeTown", usr.getHomeTown());
            temp.put("currentCity", usr.getCurrentCity());
            temp.put("usrEducation", usr.getUsrEducation());
            temp.put("isStudent", usr.getIsStudent());
            temp.put("atUniversity", usr.getAtUniversity());
            temp.put("gradUniversity", usr.getGradUniversity());
            temp.put("usrMotto", usr.getUsrMotto());
            temp.put("selfIntro", usr.getSelfIntro());
            temp.put("loverExpect", usr.getLoverExpect());
            temp.put("sayWords", usr.getSayWords());
            temp.put("usrPicture", usr.getUsrPicture());
            temp.put("invitationCards", usr.getInvitationCards());
            temp.put("calloutNum", usr.getCalloutNum());

            resArray.add(temp);
        }
        return resArray.toString();
    }

    public String collectUserInfo(User user){

        JSONObject newUser = new JSONObject();
        newUser.put("userId", user.getUsrId());
        newUser.put("userName", user.getUsrName());
        newUser.put("userWechat", user.getUsrWechat());
        newUser.put("usrTelephone", user.getUsrTelephone());
        newUser.put("usrSex", user.getUsrSex());
        newUser.put("usrHeight", user.getUsrHeight());
        newUser.put("usrAge", user.getUsrAge());
        newUser.put("usrHobby", user.getUsrHobby());
        newUser.put("birthDay", user.getBirthDay());
        newUser.put("homeTown", user.getHomeTown());
        newUser.put("currentCity", user.getCurrentCity());
        newUser.put("usrEducation", user.getUsrEducation());
        newUser.put("isStudent", user.getIsStudent());
        newUser.put("atUniversity", user.getAtUniversity());
        newUser.put("gradUniversity", user.getGradUniversity());
        newUser.put("usrMotto", user.getUsrMotto());
        newUser.put("selfIntro", user.getSelfIntro());
        newUser.put("loverExpect", user.getLoverExpect());
        newUser.put("sayWords", user.getSayWords());
        newUser.put("usrPicture", user.getUsrPicture());
        newUser.put("invitationCards", user.getInvitationCards());
        newUser.put("calloutNum", user.getCalloutNum());

        return newUser.toString();
    }
}
