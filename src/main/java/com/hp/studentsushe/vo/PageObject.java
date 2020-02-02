package com.hp.studentsushe.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageObject<T> {
    /**具体数据信息*/
    private List<T> items;
    /**总记录数*/
    private Integer total;
    /**总页数*/
    private Integer pageCount;
    /**当前页码*/
    private Integer pageCurrent;

}
