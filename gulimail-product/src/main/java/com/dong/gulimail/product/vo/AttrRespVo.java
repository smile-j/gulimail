package com.dong.gulimail.product.vo;

import lombok.Data;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/8/20
 */
@Data
public class AttrRespVo extends AttrVo{

    private String catelogName;
    private String groupName;

    private Long[] catelogPath;

}
