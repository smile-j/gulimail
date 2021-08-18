package com.dong.gulimail.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * 3、JSR303
 * 1)、给Bean添加校验注解: javax.validation.constraints，并定义自己的message提示
 * 2)、开启校验功能@Valid
 *   效果:校验错误以后会有默认的响应;
 * 3)、给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果
 * 4) 、分组校验（多场景的复杂校验）
 *      1)、@NotBLank(message =“品牌名必须提交" , groups = {AddGroup.class ,UpdateGroup.class))给校验注解标注什么情况需要进行校验
 *      2)、@Validated(AddGroup.class)
 *      3） 默认没有指定的分组的校验注解@NotBlank,在分组校验情况下@Validated(AddGroup.class)下不生效
 *          在不分组@Validated下生效
 * 5)、自定义校验
 *   1)、编写一个自定义的校验注解
 *   2) 、编写一个自定义的校验器 ConstraintValidator
 *   3)、关联自定义的校验器和自定义的校润注解
 *
 *
 * 4、统一的异常处理
 * ControlLerAdvice
 * 1) 、编写异常处理类,使用@controlLerAdviceo
 * 2)、使用@ExceptionHandler标注方法可以处理的异常。
 *
 *
 */
@SpringBootApplication
@MapperScan("com.dong.gulimail.product.dao")
@EnableDiscoveryClient
public class GulimaiProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimaiProductApplication.class, args);
    }

}
