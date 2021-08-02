package com.dong.gulimail.member.fegin;

import com.dong.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/8/2
 */
@FeignClient("coupon")
public interface CouponFeginService {

    @RequestMapping("coupon/coupon/member/list")
    public R memberCoupons();

}
