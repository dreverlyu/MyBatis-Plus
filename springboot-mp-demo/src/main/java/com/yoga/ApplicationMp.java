package com.yoga;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yoga.sales.mapper")
public class ApplicationMp {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMp.class,args);

    }
}

