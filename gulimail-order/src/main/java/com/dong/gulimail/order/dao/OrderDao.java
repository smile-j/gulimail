package com.dong.gulimail.order.dao;

import com.dong.gulimail.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-08-01 22:31:58
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
