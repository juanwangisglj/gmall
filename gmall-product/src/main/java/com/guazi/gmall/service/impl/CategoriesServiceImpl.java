package com.guazi.gmall.service.impl;

import com.guazi.gmall.mapper.CategoriesMapper;
import com.guazi.gmall.service.CategoriesService;
import com.guazi.gmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xf
 * @Date 2022/1/29 6:09 下午
 **/
@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public int get() {
        return categoriesMapper.get();
    }
}
