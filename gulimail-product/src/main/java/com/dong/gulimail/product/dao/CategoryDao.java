package com.dong.gulimail.product.dao;

import com.dong.gulimail.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-07-31 16:50:50
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
