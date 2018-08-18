package com.firstmeetschool.school;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.firstmeetschool.school.dao")
public class SchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);// 启动spring应用，第一个参数是应用的入口类，第二个参数是spring应用的命令行参数
    }
}
