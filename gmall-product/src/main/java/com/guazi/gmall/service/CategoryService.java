package com.guazi.gmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guazi.common.utils.ResultBean;
import com.guazi.gmall.model.entity.CategoryDO;

import java.util.List;

/**
 * @author glj
 * @date 2022/1/27 1:15 下午
 */
public interface CategoryService extends IService<CategoryDO>{

    ResultBean listWithTree();



}
