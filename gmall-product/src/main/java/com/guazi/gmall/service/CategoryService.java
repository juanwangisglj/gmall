package com.guazi.gmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guazi.gmall.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author glj
 * @date 2022/1/27 1:15 下午
 */
public interface CategoryService extends IService<CategoryEntity>{

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> ids);


}
