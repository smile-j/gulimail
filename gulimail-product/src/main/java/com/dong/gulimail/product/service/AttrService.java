package com.dong.gulimail.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.common.utils.PageUtils;
import com.dong.gulimail.product.entity.AttrEntity;
import com.dong.gulimail.product.vo.AttrVo;

import java.util.Map;

/**
 * 商品属性
 *
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-07-31 16:50:50
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void  save(AttrVo vo);

    PageUtils baseAttrPage(Map<String, Object> params, Long cateLogId);

    AttrVo getAttrInfo(Long attrId);

    void updateById(AttrVo attrVo);
}

