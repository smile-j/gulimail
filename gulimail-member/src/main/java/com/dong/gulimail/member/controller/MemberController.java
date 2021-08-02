package com.dong.gulimail.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.dong.gulimail.member.fegin.CouponFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dong.gulimail.member.entity.MemberEntity;
import com.dong.gulimail.member.service.MemberService;
import com.dong.common.utils.PageUtils;
import com.dong.common.utils.R;



/**
 * 会员
 *
 * @author litter_pi
 * @email 11@qq.com
 * @date 2021-08-01 13:08:52
 */
@RestController
@RequestMapping("member/member")
public class MemberController {

    @Autowired
    private CouponFeginService couponFeginService;
    @Autowired
    private MemberService memberService;

    @RequestMapping("/coupons")
    public R test(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("张三");
        R r = couponFeginService.memberCoupons();
        return  R.ok().put("member",memberEntity).put("coupons",r.get("coupons"));

    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
