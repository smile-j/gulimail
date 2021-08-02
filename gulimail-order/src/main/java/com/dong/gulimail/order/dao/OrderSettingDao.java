package com.dong.gulimail.order.dao;

import com.dong.gulimail.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-08-01 22:31:59
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}
