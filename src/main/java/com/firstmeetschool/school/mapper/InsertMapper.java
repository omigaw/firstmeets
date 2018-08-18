package com.firstmeetschool.school.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InsertMapper {

    @Insert("INSERT INTO user(usrWechat, usrName, usrTelephone, usrHeight, usrAge, homeTown, currentCity, usrSex, usrEducation, isStudent) " +
            "VALUES (#{usrWechat}, #{usrName}, #{usrTelephone}, #{usrHeight}, #{usrAge}, #{homeTown}, #{currentCity}, #{usrSex}, #{usrEducation}, #{isStudent})")
    int insertUser(@Param("usrWechat") String usrWechat, @Param("usrName") String usrName, @Param("usrTelephone") String usrTelephone,
                    @Param("usrHeight") String usrHeight, @Param("usrAge") String usrAge, @Param("homeTown") String homeTown, @Param("currentCity") String currentCity,
                    @Param("usrSex") String usrSex, @Param("usrEducation") String usrEducation, @Param("isStudent") String isStudent);




}
