package com.guazi.gmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guazi.gmall.entity.CategoryEntity;
import com.guazi.gmall.mapper.CategoryMapper;
import com.guazi.gmall.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author glj
 * @date 2022/1/27 1:16 下午
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,CategoryEntity> implements CategoryService {



    /**
     * 三级分类开发,返回树形结构的三级分类
     * @return
     */
    @Override
    public List<CategoryEntity> listWithTree() {


        List<CategoryEntity> categoryEntities = super.baseMapper.selectList(null);

        return categoryEntities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(item -> {
                    item.setChildren(getChildrens(item, categoryEntities));
                    return item;
                })
                .sorted((item1, item2) -> {
                    return (item1.getSort() == null ? 0 : item1.getSort()) - (item2.getSort() == null ? 0 : item2.getSort());
                }).collect(Collectors.toList());
    }

    /**
     * 删除指定ids集合的三级分类
     * @param ids
     */
    @Override
    public void removeMenuByIds(List<Long> ids) {
        //TODO 1 检查当前的菜单是否被别的地方所引用 比如品牌会关联三级分类
        super.baseMapper.deleteBatchIds(ids);
    }



    /**
     * 递归查找所有菜单的子菜单
     * @param root 要查找的父级分类
     * @param all 所有的分类
     * @return
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream()
                .filter(categoryEntity -> {
                    return categoryEntity.getParentCid().equals(root.getCatId());
                })
                .map(categoryEntity -> {
                    categoryEntity.setChildren(getChildrens(categoryEntity, all));
                    return categoryEntity;
                }).sorted((menu, menu2) -> {
                    //2、菜单的排序
                    return (menu.getSort() == null ? 0 : menu.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
                }).collect(Collectors.toList());
    }
}
