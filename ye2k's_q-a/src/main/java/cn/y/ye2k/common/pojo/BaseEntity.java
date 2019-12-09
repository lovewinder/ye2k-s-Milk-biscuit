package cn.y.ye2k.common.pojo;

import lombok.Data;

/**
 * 基本POJO用于 显示4个审计字段
 * @author caolei @date 2019/12/8 20:53
 */
@Data
public class BaseEntity {
    /**
     * 最近修改人
     */
    private String updatedBy;
    /**
     * 最近修改时间
     */
    private java.sql.Date updatedDate;
    /**
     * 数据创建人
     */
    private String createdBy;
    /**
     * 数据创建时间
     */
    private java.sql.Date createdDate;
}
