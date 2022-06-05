package com.mf.test;

import com.mf.dao.ProductMapper;
import com.mf.entity.Roles;
import com.mf.service.RolesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfig.xml")
public class Test01 {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void testget() {
        System.out.println(productMapper.getProductCount(null));
    }
}
