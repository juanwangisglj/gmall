package com.guazi.common.utils;

import com.guazi.common.constant.CommonPage;
import com.guazi.common.constant.PageParameter;

import java.util.Collections;
import java.util.List;

/**
 * @Author xf
 * @Date 2022/1/29 5:44 下午
 **/
public class PageUtil {

    public static <T> CommonPage<T> result(final PageParameter pageParameter, final int count, final List<T> data) {
        if (count > 0) {
            return new CommonPage<>(new PageParameter(pageParameter.getCurrentPage(), pageParameter.getPageSize(), count), data);
        }
        return new CommonPage<>(new PageParameter(pageParameter.getCurrentPage(), pageParameter.getPageSize(), 0), Collections.emptyList());
    }
}
