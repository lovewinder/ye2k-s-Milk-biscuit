package cn.y.ye2k.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "tab_bookcasesection")
@Data
public class BookCaseSection {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer sid;

    public BookCaseSection(String sectionName, Integer cid, String createTime, String mdurl) {
        this.sectionName = sectionName;
        this.cid = cid;
        this.createTime = createTime;
        this.mdurl = mdurl;
    }

    public BookCaseSection() {
    }

    private String sectionName;
    private Integer cid;// 所属的Chapter的编号
    private String createTime;
    private String mdurl;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMdurl() {
        return mdurl;
    }

    public void setMdurl(String mdurl) {
        this.mdurl = mdurl;
    }
}
