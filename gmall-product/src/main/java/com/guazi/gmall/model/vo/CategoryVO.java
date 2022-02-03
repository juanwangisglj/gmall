package com.guazi.gmall.model.vo;

import com.guazi.gmall.model.entity.CategoryDO;
import lombok.Data;

import java.util.List;

/**
 * @Author xf
 * @Date 2022/2/1 11:58 上午
 **/
@Data
public class CategoryVO {

    /**
     * 分类id
     */
    private Long catId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父分类id
     */
    private Long parentCid;
    /**
     * 层级
     */
    private Integer catLevel;
    /**
     * 是否显示[0-不显示，1显示]
     */
    private Integer showStatus;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图标地址
     */
    private String icon;
    /**
     * 计量单位
     */
    private String productUnit;
    /**
     * 商品数量
     */
    private Integer productCount;

    /**
     * 所有子分类
     */
    private List<CategoryVO> children;
}
