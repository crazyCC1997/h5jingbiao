package com.dy.h5jingbiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dy.h5jingbiao.mapper")
@SpringBootApplication
public class H5jingbiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(H5jingbiaoApplication.class, args);
    }

}
