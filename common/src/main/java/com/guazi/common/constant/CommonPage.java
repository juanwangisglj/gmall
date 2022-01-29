package com.guazi.common.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author xf
 * @Date 2022/1/29 5:41 下午
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonPage<T> implements Serializable {

    private static final long serialVersionUID = -1220101004792874251L;

    /**
     * page.
     */
    private PageParameter page;

    /**
     * data.
     */
    private List<T> list;
}
