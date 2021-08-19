package com.dong.gulimail.product.service.impl;

import com.dong.gulimail.product.service.CategoryBrandRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.common.utils.PageUtils;
import com.dong.common.utils.Query;

import com.dong.gulimail.product.dao.BrandDao;
import com.dong.gulimail.product.entity.BrandEntity;
import com.dong.gulimail.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        IPage<BrandEntity> page = null;
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(key)){
            queryWrapper.eq("brand_id",key).or().like("name",key);
        }
        page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper
        );



        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);
        if(StringUtils.isNotBlank(brand.getName())){
            categoryBrandRelationService.updateBrand(brand.getBrandId(),brand.getName());
            /**
             * 更新其他的关联
             */
        }
    }

}