package com.dong.gulimail.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  1.引入jar包
 *     <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *      </dependency>
 *  2.创建bootstrap.properties
 *  3.需要在配置中心添加数据集（data-id) coupon-properties  默认规则：应用名.properties
 *  4.动态刷新 @RefreshScope
 *      如果配置中心和当前应用的配置文件中配置了相同的项 配置中心优先
 *
 *
 *  1.命名空间：配置隔离
 *      基于环境或者环境
 *  2.配置集 ：所有配置的集合
 *  3.配置id:类似配置文件名
 *
 *  4.配置分组：
 *      默认配置集都所属：DEFAULT_GROUP
 *      11.11  6.18   12.12
 *
 *
 */
@SpringBootApplication
@MapperScan("com.dong.gulimail.coupon.dao")
@EnableDiscoveryClient
public class GulimailCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimailCouponApplication.class, args);
    }

}
