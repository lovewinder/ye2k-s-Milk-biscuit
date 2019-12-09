package cn.y.ye2k.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tab_bookcase")
@Data
public class BookInCase {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer bid;//用户id
    private String bookName;
    private String type;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BookInCase(Integer bid,String bookName, String type) {
        this.bid = bid;
        this.bookName = bookName;
        this.type = type;
    }

    public BookInCase() {
    }
}
