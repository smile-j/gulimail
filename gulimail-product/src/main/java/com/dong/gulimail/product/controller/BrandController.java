package com.dong.gulimail.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.dong.common.vaild.AddGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dong.gulimail.product.entity.BrandEntity;
import com.dong.gulimail.product.service.BrandService;
import com.dong.common.utils.PageUtils;
import com.dong.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-08-01 07:05:10
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存  保存时校验
     */
    @RequestMapping("/save")
    public R save(@Validated(AddGroup.class) @RequestBody BrandEntity brand){
       /* if(result.hasErrors()){
            Map<String,String> map = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                map.put(e.getField(),e.getDefaultMessage());
            });
            return R.error(400,"提交参数不合法");
        }else {
            brandService.save(brand);
        }*/
        int b= 1/0;
        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateDetail(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
