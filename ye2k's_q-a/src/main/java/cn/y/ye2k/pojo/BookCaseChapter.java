package cn.y.ye2k.pojo;

import cn.y.ye2k.common.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 图书章节???or书签
 *
 * @author ye2k's look-up 内测小组
 * @date 2019-12
 */
@Table(name = "tab_bookCase")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCaseChapter extends BaseEntity {

    @Id
    @GeneratedValue(generator = "JDBC")
    /**
     * 章节ID
     */
    private Integer cid;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 所属的书的编号
     */
    private Integer bid;
    /**
     * 创建时间
     */
    private String createTime;

    public BookCaseChapter(String chapterName, Integer bid, String createTime) {
        this.chapterName = chapterName;
        this.bid = bid;
        this.createTime = createTime;
    }
}
