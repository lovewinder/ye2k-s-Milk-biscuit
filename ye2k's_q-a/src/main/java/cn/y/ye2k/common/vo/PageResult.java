package cn.y.ye2k.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 自封装通用的分页结果类
 * *@Data get/set方法
 * *@NoArgsConstructor 空参构造
 * *@AllArgsConstructor 满参构造
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    /**总数据条数*/
    private Long total;
    /**总页码*/
    private Integer totalPage;
    /**查询到的实体类集合*/
    private List<T> items;
}
