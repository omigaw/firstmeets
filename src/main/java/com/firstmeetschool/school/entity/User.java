package com.firstmeetschool.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer usrId;

    @NotBlank(message = "请输入微信号")
    private String usrWechat;

    @NotBlank(message = "请输入姓名")
    private String usrName;

    @NotBlank(message = "请输入手机号")
    private String usrTelephone;

    @NotNull(message = "请输入身高" )
    private Float usrHeight;

    @Min(value = 18,message = "未成年")
    private Integer usrAge;

    @NotNull(message = "请输入家乡" )
    private String homeTown;

    @NotNull(message = "请输入所在城市" )
    private String currentCity;

    @NotNull
    private String usrSex;

    @NotNull
    private String usrEducation;

    @NotNull
    private String isStudent;

    private String atUniversity;

    private String gradUniversity;

    private String usrHobby;

    private String birthDay;

    private String usrMotto;

    private String selfIntro;

    private String usrPicture;

    private String loverExpect;

    private String sayWords;

    // 邀请卡
    private Integer invitationCards;

    // 点赞数
    private Integer calloutNum;

    // 用户状态，0：创建未认证(比如没有激活，没有输入验证码等等)--等待验证的用户，1：正常状态，2：用户被锁定。
    /*private byte state;*/

    public void setUsrId(Integer usrId){ this.usrId = usrId;}

    public Integer getUsrId() {return usrId;}

    public void setUsrName(String usrName) { this.usrName = usrName; }

    public String getUsrName() {return usrName; }

    public void setUsrWechat(String usrWechat) {this.usrWechat = usrWechat; }

    public String getUsrWechat(){return usrWechat;}

    public void setUsrTelephone(String usrTelephone) { this.usrTelephone = usrTelephone;}

    public String getUsrTelephone() { return usrTelephone;}

    public void setUsrHeight(Float usrHeight) { this.usrHeight = usrHeight;}

    public Float getUsrHeight() { return usrHeight;}

    public void setUsrAge(Integer usrAge) {this.usrAge = usrAge;}

    public Integer getUsrAge(){ return usrAge;}

    public void setHomeTown(String homeTown) {this.homeTown = homeTown;}

    public String getHomeTown() { return homeTown;}

    public void setCurrentCity(String currentCity) {this.currentCity = currentCity;}

    public String getCurrentCity(){ return currentCity;}

    public void setUsrSex(String usrSex) {this.usrSex = usrSex;}

    public String getUsrSex() {return usrSex;}

    public void setUsrEducation(String usrEducation) {this.usrEducation = usrEducation;}

    public String getUsrEducation() {return usrEducation;}

    public void setIsStudent(String isStudent) {this.isStudent = isStudent;}

    public String getIsStudent(){ return isStudent; }

    public void setAtUniversity(String atUniversity) {this.atUniversity = atUniversity;}

    public String getAtUniversity() { return atUniversity;}

    public void setGradUniversity(String gradUniversity) {this.gradUniversity = gradUniversity;}

    public String getGradUniversity() {return gradUniversity;}

    public void setUsrHobby(String usrHobby) {this.usrHobby = usrHobby;}

    public String getUsrHobby() {return usrHobby;}

    public void setBirthDay(String birthDay) {this.birthDay = birthDay;}

    public String getBirthDay() {return birthDay;}

    public void setUsrMotto(String usrMotto) {this.usrMotto = usrMotto;}

    public String getUsrMotto() {return usrMotto;}

    public void setSelfIntro(String selfIntro) { this.selfIntro = selfIntro;}

    public String getSelfIntro() {return selfIntro;}

    public void setUsrPicture(String usrPicture) {this.usrPicture = usrPicture;}

    public String getUsrPicture() {return usrPicture;}

    public void setLoverExpect(String loverExpect) {this.loverExpect = loverExpect;}

    public String getLoverExpect() {return loverExpect;}

    public void setSayWords(String sayWords) {this.sayWords = sayWords;}

    public String getSayWords() {return sayWords;}

    public void setInvitationCards(Integer invitationCards) {this.invitationCards = invitationCards;}

    public Integer getInvitationCards() {return invitationCards;}

    public void setCalloutNum(Integer calloutNum) {this.calloutNum = calloutNum;}

    public Integer getCalloutNum() { return calloutNum; }



    @Override
    public String toString(){

        return "User{" +
                "usrId=" + usrId +
                ", usrName='" + usrName + '\'' +
                ", usrWechat='" + usrWechat + '\'' +
                ", usrAge=" + usrAge +
                ", usrSex='" + usrSex + '\'' +
                ", usrHeight=" + usrHeight +
                ", usrMotto='" + usrMotto + '\'' +
                ", usrTelephone='" + usrTelephone + '\'' +
                ", usrEducation='" + usrEducation + '\'' +
                ", usrHobby='" + usrHobby + '\'' +
                ", isStudent='" + isStudent + '\'' +
                ", atUniversity='" + atUniversity + '\'' +
                ", gradUniversity='" + gradUniversity + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", currentCity='" + currentCity + '\'' +
                ", selfIntro='" + selfIntro + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", usrPicture='" + usrPicture + '\'' +
                ", loverExpect='" + loverExpect + '\'' +
                ", sayWords='" + sayWords + '\'' +
                ", invitationCards=" + invitationCards +
                ", calloutNum=" + calloutNum +
                '}';
    }

}
