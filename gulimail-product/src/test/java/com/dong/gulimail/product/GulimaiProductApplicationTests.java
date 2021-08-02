package com.dong.gulimail.product;

import com.dong.gulimail.product.entity.BrandEntity;
import com.dong.gulimail.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimaiProductApplicationTests {

    @Autowired
    private BrandService brandService;
    @Test
    void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("test111");
        brandService.save(brandEntity);

    }

}
