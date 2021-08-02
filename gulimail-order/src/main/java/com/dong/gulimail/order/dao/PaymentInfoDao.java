package com.dong.gulimail.order.dao;

import com.dong.gulimail.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-08-01 22:31:59
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
