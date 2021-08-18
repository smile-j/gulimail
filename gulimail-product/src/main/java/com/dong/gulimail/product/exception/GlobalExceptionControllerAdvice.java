package com.dong.gulimail.product.exception;

import com.dong.common.exception.BizCodeEnume;
import com.dong.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/8/17
 */
//@ControllerAdvice(basePackages = "com.dong.gulimail.product.controller")
//@ResponseBody
@RestControllerAdvice(basePackages = "com.dong.gulimail.product.controller")
@Slf4j
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException ee){

      log.error("1数据校验出现问题{}，异常类型：{}",ee.getMessage(),ee.getClass());
        Map<String,String> map = new HashMap<>();
      ee.getBindingResult().getFieldErrors().forEach(e->{
          map.put(e.getField(),e.getDefaultMessage());
      });
//        return R.error(400,"提交参数不合法");
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(),BizCodeEnume.VAILD_EXCEPTION.getName()).put("data",map);
    }


    @ExceptionHandler(value = Throwable.class)
    public R handleVaildException(Throwable e){

        log.error("2数据校验出现问题{}，异常类型：{}",e.getMessage(),e.getClass());
        return R.error(BizCodeEnume.UNNKOW_EXCEPTION.getCode(),BizCodeEnume.UNNKOW_EXCEPTION.getName());
    }


}
