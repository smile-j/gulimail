package com.dong.gulimail.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.dong.gulimail.product.dao")
@EnableDiscoveryClient
public class GulimaiProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimaiProductApplication.class, args);
    }

}
