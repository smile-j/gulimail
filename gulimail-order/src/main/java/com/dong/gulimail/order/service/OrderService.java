package com.dong.gulimail.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.common.utils.PageUtils;
import com.dong.gulimail.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-08-01 22:31:58
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

