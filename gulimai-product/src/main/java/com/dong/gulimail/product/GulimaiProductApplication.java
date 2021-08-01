package com.dong.gulimail.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.dong.gulimail.product.dao")
public class GulimaiProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimaiProductApplication.class, args);
    }

}
