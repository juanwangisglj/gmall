package com.guazi.gmall.controller;

import com.guazi.common.utils.R;
import com.guazi.gmall.entity.CategoryEntity;
import com.guazi.gmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

/**
 * @author glj
 * @date 2022/1/27 1:14 下午
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    /**
     * 三级分类查询接口（以树形结构返回）
     * @return
     */
    @GetMapping("/list/tree")
    public R getCategoryWithTree(){
        List<CategoryEntity> categoryEntities = categoryService.listWithTree();
        return R.ok().put("data",categoryEntities);
    }

    /**
     * 删除三级分类
     * @param catIds
     * @return
     */
    @GetMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
        categoryService.removeMenuByIds(Arrays.asList(catIds));
        return R.ok();
    }

    /**
     * 三级分类的更新
     * @param categoryEntity
     * @return
     */
    public R update(@RequestBody CategoryEntity categoryEntity) {
        categoryService.updateById(categoryEntity);
        return R.ok();
    }

}
