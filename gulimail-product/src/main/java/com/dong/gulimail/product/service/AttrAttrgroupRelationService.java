package com.dong.gulimail.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.common.utils.PageUtils;
import com.dong.gulimail.product.entity.AttrAttrgroupRelationEntity;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-07-31 16:50:50
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

