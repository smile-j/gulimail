package com.dong.common.exception;

import lombok.Getter;

/**
 * @author dongjunpeng
 * @Description
 *
 * *错误码和错误信息定义类*1.错误码定义规则为5为数字
 * *2．前两位表示业务场景，最后三位表示错误码。例如:100001。10:通用001:系统未知异常
 * *3.维护错误码后需要维护错误描述，将他们定义为枚举形式*错误码列表:
 * *10:通用
 *      001:参数格式校验
 * 11:商品
 * 12:订单
 * 13:购物车
 * *14:物流
 *
 * @date 2021/8/17
 */
@Getter
public enum BizCodeEnume {

    UNNKOW_EXCEPTION(10000,"系统异常"),
    VAILD_EXCEPTION(10001,"参数格式失败");

    private BizCodeEnume(Integer code,String name){
        this.code = code;
        this.name = name;
    }
    private Integer code;
    private String name;

}
