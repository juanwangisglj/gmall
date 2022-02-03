package com.guazi.gmall.controller;

import com.guazi.common.utils.R;
import com.guazi.common.utils.ResultBean;
import com.guazi.gmall.model.entity.CategoryDO;
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
    public ResultBean getCategoryWithTree(){
        return categoryService.listWithTree();
    }

}
