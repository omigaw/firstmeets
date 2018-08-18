package com.firstmeetschool.school.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UpdateMapper {

    @Update("update user set usrWechat = #{usrWechat}, usrName = #{usrName}, usrTelephone = #{usrTelephone}, " +
            "usrHeight = #{usrHeight}, usrAge = #{usrAge}, homeTown = #{homeTown}, currentCity = #{currentCity}, " +
            "usrSex = #{usrSex},  usrEducation = #{usrEducation}, isStudent = #{isStudent}")
    int updateUser(@Param("usrWechat") String usrWechat, @Param("usrName") String usrName, @Param("usrTelephone") String usrTelephone,
                   @Param("usrHeight") String usrHeight, @Param("usrAge") String usrAge, @Param("homeTown") String homeTown, @Param("currentCity") String currentCity,
                   @Param("usrSex") String usrSex, @Param("usrEducation") String usrEducation, @Param("isStudent") String isStudent);

}
