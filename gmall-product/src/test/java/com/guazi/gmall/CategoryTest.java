package com.guazi.gmall;

import com.guazi.gmall.entity.CategoryEntity;
import com.guazi.gmall.mapper.CategoryMapper;

import com.guazi.gmall.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author glj
 * @date 2022/1/27 2:57 下午
 */
@SpringBootTest
public class CategoryTest {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryService categoryService;

    @Test
    public void testCategory(){
        List<CategoryEntity> categoryEntities = categoryService.listWithTree();
        System.out.println(categoryEntities);
    }
}
