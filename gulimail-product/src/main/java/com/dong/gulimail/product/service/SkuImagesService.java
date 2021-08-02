package com.dong.gulimail.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.common.utils.PageUtils;
import com.dong.gulimail.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-07-31 16:50:50
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

