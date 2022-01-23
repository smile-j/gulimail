package com.dong.gulimail.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.dong.gulimail.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dong.gulimail.product.entity.AttrEntity;
import com.dong.gulimail.product.service.AttrService;
import com.dong.common.utils.PageUtils;
import com.dong.common.utils.R;



/**
 * 商品属性
 *
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-08-01 07:05:10
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @GetMapping("/base/attr/{cateLogId}")
    public R baseAttrList(@RequestParam Map<String,Object> params,
                          @PathVariable("cateLogId") Long cateLogId){
        PageUtils page = attrService.baseAttrPage(params,cateLogId);
        return R.ok().put("page",page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
//		AttrEntity attr = attrService.getById(attrId);
        AttrVo attrVo = attrService.getAttrInfo(attrId);
        return R.ok().put("attr", attrVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
		attrService.save(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVo attrVo){
		attrService.updateById(attrVo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
