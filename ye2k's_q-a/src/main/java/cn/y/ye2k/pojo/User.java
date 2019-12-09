package cn.y.ye2k.pojo;


import cn.y.ye2k.common.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表
 *
 * @author ye2k's look-up 内测小组
 * @date 2019-12-08
 */
@Table(name = "TAB_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{

    @Id
    @GeneratedValue(generator = "JDBC")
    /**
     * 用户ID主键
     */
    private String umId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private java.sql.Date birthDate;
    /**
     * 组织编号
     */
    private String orgId;
    /**
     * 角色编号
     */
    private String roleId;
    /**
     * 注册时间
     */
    private java.sql.Date registerDate;
    /**
     * 最近上线时间
     */
    private java.sql.Date qualtfiedToLineDate;
    /**
     * 是否允许使用系统,Y允许,N不允许
     */
    private String isSystemPermitted;


}
/**
 * 建表语句
 * CREATE TABLE `TAB_USER` (
 *   `UM_ID` varchar(20) NOT NULL COMMENT '系统账号',
 *   `USER_NAME` varchar(50) NOT NULL COMMENT '用户名',
 *   `PASSWORD` varchar(20) NOT NULL COMMENT '密码',
 *   `SEX` varchar(1) DEFAULT NULL COMMENT '性别,M男性,F女性',
 *   `BIRTH_DATE` date DEFAULT NULL COMMENT '出生日期',
 *   `ORG_ID` varchar(6) DEFAULT NULL COMMENT '组织编号',
 *   `ROLE_ID` varchar(6) DEFAULT NULL COMMENT '角色编号',
 *   `REGISTER_DATE` date DEFAULT NULL COMMENT '注册时间',
 *   `QUALTFIED_TO_LINE_DATE` date DEFAULT NULL COMMENT '最近上线时间',
 *   `IS_SYSTEM_PERMITTED` varchar(1) DEFAULT NULL COMMENT '是否允许使用系统,Y允许,N不允许',
 *   `UPDATED_BY` varchar(50) DEFAULT NULL COMMENT '最近修改人',
 *   `UPDATED_DATE` date DEFAULT NULL COMMENT '最近修改时间',
 *   `CREATED_BY` varchar(50) DEFAULT NULL COMMENT '数据创建人',
 *   `CREATED_DATE` date DEFAULT NULL COMMENT '数据创建时间',
 *   PRIMARY KEY (`UM_ID`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
