package com.dong.gulimail.coupon.dao;

import com.dong.gulimail.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-08-01 08:11:00
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
