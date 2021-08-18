package com.dong.gulimail.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.common.utils.PageUtils;
import com.dong.common.utils.Query;

import com.dong.gulimail.product.dao.CategoryDao;
import com.dong.gulimail.product.entity.CategoryEntity;
import com.dong.gulimail.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {

        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        List<CategoryEntity> firstList = categoryEntities.stream().filter(e -> 0 == e.getParentCid())
                .map(menu->{
                    menu.setChildren(getChidrens(menu,categoryEntities));
                    return menu;
                })
                .sorted((e1,e2)->{
                    return (e1.getSort()==null?0:e1.getSort())-(e2.getSort()==null?0:e2.getSort());
                })
                .collect(Collectors.toList());


        return categoryEntities;
    }

    @Override
    public void removeMenuByIds(List<Long> ids) {
        /**
         * todo 检查是否被其他引用
         */
        baseMapper.deleteBatchIds(ids);
    }

    private List<CategoryEntity> getChidrens(CategoryEntity root,List<CategoryEntity>  entities){

        List<CategoryEntity> collect = entities.stream().filter(e -> e.getParentCid().equals(root.getCatId()))
                .map(categoryEntity ->{
                    categoryEntity.setChildren(getChidrens(categoryEntity,entities));
                 return categoryEntity;
                })
                .sorted((e1,e2)->{
                    return (e1.getSort()==null?0:e1.getSort())-(e2.getSort()==null?0:e2.getSort());
                })
                .collect(Collectors.toList());
        return collect;

    }

}