package com.taizhou.taizhou_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.taizhou.taizhou_back.mapper")
public class TaizhouBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaizhouBackApplication.class, args);
    }

}
