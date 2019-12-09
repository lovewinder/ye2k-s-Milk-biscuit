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
 * @date 2019-12
 */
@Table(name = "tab_qa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QA extends BaseEntity {
    @Id
    @GeneratedValue(generator = "JDBC")
    /**
     * 用户id
     */
    private Integer uid;
    private Integer index;
    /**
     * 问题,题目
     */
    private String question;
    /**
     * 回答,答案
     */
    private String answer;

    public QA(Integer index, String question, String answer) {
        this.index = index;
        this.question = question;
        this.answer = answer;
    }
}
