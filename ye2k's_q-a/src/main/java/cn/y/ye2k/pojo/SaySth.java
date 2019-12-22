package cn.y.ye2k.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tab_saySth")
@Data
public class SaySth {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer sid;//用户id
    private String content;
    private String createTime;

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    private String creater;


    public SaySth() {

    }

    public SaySth(String content, String createTime, String creater) {
        this.content = content;
        this.createTime = createTime;
        this.creater = creater;
    }

    public SaySth(String content, String createTime) {
        this.content = content;
        this.createTime = createTime;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
