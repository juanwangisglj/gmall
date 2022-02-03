package com.guazi.gmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guazi.common.utils.ResultBean;
import com.guazi.gmall.mapper.CategoryMapper;
import com.guazi.gmall.model.entity.CategoryDO;
import com.guazi.gmall.model.vo.CategoryVO;
import com.guazi.gmall.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author glj
 * @date 2022/1/27 1:16 下午
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDO> implements CategoryService {


    @Override
    public ResultBean listWithTree() {

        List<CategoryDO> categoryDOS = super.baseMapper.selectList(null);
        List<CategoryVO> categoryVOS = new ArrayList<>();
        for (CategoryDO categoryDO : categoryDOS) {
            if (categoryDO.getParentCid() == 0) {
                CategoryVO categoryVO = CategoryDO.build(categoryDO);
                categoryVOS.add(categoryVO);
            }
//            categoryVOS.sort(Comparator.comparing(CategoryVO::getSort));
        }
        getSubCategory(categoryVOS, categoryDOS);
        return ResultBean.success(categoryVOS);
    }

    public void getSubCategory(List<CategoryVO> categoryVOS, List<CategoryDO> categoryDOS) {
        for (CategoryVO categoryVO : categoryVOS) {
            List<CategoryVO> subCategoryVOS = new ArrayList<>();
            for (CategoryDO categoryDO : categoryDOS) {
                if (categoryVO.getCatId().equals(categoryDO.getParentCid())) {
                    CategoryVO subCategoryVO = CategoryDO.build(categoryDO);
                    subCategoryVOS.add(subCategoryVO);
//                    subCategoryVOS.sort(Comparator.comparing(CategoryVO::getSort));
                    categoryVO.setChildren(subCategoryVOS);
                }
            }
            getSubCategory(subCategoryVOS, categoryDOS);
        }
    }

}
