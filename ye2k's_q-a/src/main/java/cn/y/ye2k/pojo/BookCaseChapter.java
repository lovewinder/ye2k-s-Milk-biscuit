package cn.y.ye2k.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tab_bookCase")
@Data
public class BookCaseChapter {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer cid;

    public BookCaseChapter(String chapterName, Integer bid, String createTime) {
        this.chapterName = chapterName;
        this.bid = bid;
        this.createTime = createTime;
    }

    public BookCaseChapter() {
    }

    private String chapterName;
    private Integer bid;// 所属的书的编号
    private String createTime;
}
