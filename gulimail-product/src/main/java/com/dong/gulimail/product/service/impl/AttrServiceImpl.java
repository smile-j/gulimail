package com.dong.gulimail.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dong.gulimail.product.dao.AttrAttrgroupRelationDao;
import com.dong.gulimail.product.dao.AttrGroupDao;
import com.dong.gulimail.product.dao.CategoryDao;
import com.dong.gulimail.product.entity.AttrAttrgroupRelationEntity;
import com.dong.gulimail.product.entity.AttrGroupEntity;
import com.dong.gulimail.product.entity.CategoryEntity;
import com.dong.gulimail.product.service.CategoryService;
import com.dong.gulimail.product.vo.AttrRespVo;
import com.dong.gulimail.product.vo.AttrVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.common.utils.PageUtils;
import com.dong.common.utils.Query;

import com.dong.gulimail.product.dao.AttrDao;
import com.dong.gulimail.product.entity.AttrEntity;
import com.dong.gulimail.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;
    @Autowired
    private AttrDao attrDao;
    @Autowired
    private AttrGroupDao attrgroupDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryService categoryService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void save(AttrVo vo) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(vo,attrEntity);
        this.save(attrEntity);
        AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
        relationEntity.setAttrId(vo.getAttrId());
        relationEntity.setAttrGroupId(vo.getAttrGroupId());
        attrAttrgroupRelationDao.insert(relationEntity);
    }

    @Override
    public PageUtils baseAttrPage(Map<String, Object> params, Long cateLogId) {
        QueryWrapper<AttrEntity> attrEntityQueryWrapper = new QueryWrapper<>();

        if(cateLogId!=0){
            attrEntityQueryWrapper.eq("catelog_id",cateLogId);
        }
        String key = (String) params.get("key");
        if(StringUtils.isNotBlank(key)){
            attrEntityQueryWrapper.and((wrap)->{
               wrap.eq("attr_id",key).or().like("attr_name",key);
            });

        }

        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                attrEntityQueryWrapper
        );

        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> list = (List<AttrEntity>) pageUtils.getList();
        List<AttrRespVo> vos = list.stream().map((e) -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(e, attrRespVo);
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = attrAttrgroupRelationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", e.getAttrId()));
            if (attrAttrgroupRelationEntity != null) {
                CategoryEntity categoryEntity = categoryDao.selectById(attrAttrgroupRelationEntity.getAttrGroupId());
                attrRespVo.setGroupName(categoryEntity.getName());

            }
            CategoryEntity categoryEntity = categoryDao.selectById(e.getCatelogId());
            attrRespVo.setCatelogName(categoryEntity.getName());

            return attrRespVo;
        }).collect(Collectors.toList());

         pageUtils.setList(vos);
         return pageUtils;
    }

    @Override
    public AttrVo getAttrInfo(Long attrId) {
        AttrEntity attrEntity = this.getById(attrId);
        AttrRespVo attrVo = new AttrRespVo();
        BeanUtils.copyProperties(attrEntity,attrVo);

        //分组信息
        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = attrAttrgroupRelationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>()
                .eq("attr_id", attrEntity.getAttrId()));
        if(attrAttrgroupRelationEntity!=null){
            attrVo.setAttrGroupId(attrAttrgroupRelationEntity.getAttrGroupId());
            AttrGroupEntity attrGroupEntity = attrgroupDao.selectById(attrAttrgroupRelationEntity.getAttrGroupId());
            if(attrGroupEntity!=null){
                attrVo.setGroupName(attrGroupEntity.getAttrGroupName());
            }
        }
        //设置分类
        Long cateLogId = attrEntity.getCatelogId();
        Long[] catelogPath = categoryService.findCatelogPath(cateLogId);
        attrVo.setCatelogPath(catelogPath);

        CategoryEntity categoryEntity = categoryDao.selectById(cateLogId);
        if(categoryEntity!=null){
            attrVo.setCatelogName(categoryEntity.getName());
        }
        return attrVo;
    }

    @Override
    public void updateById(AttrVo attrVo) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attrEntity,attrVo);
        this.updateById(attrEntity);

        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelationEntity.setAttrGroupId(attrVo.getAttrGroupId());
        attrAttrgroupRelationEntity.setAttrId(attrVo.getAttrId());



        Integer num = attrAttrgroupRelationDao.selectCount(new UpdateWrapper<AttrAttrgroupRelationEntity>()
                .eq("attr_id", attrEntity.getAttrId()));
        if(num>0){
            attrAttrgroupRelationDao.update(attrAttrgroupRelationEntity,new UpdateWrapper<AttrAttrgroupRelationEntity>()
                    .eq("attr_id",attrEntity.getAttrId()));
        }else {
            attrAttrgroupRelationDao.insert(attrAttrgroupRelationEntity);
        }
    }

}