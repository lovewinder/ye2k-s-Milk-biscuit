package cn.y.ye2k.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tab_qa")
@Data
public class QA {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer uid;//用户id
    private Integer index;
    private String question;
    private String answer;

    public QA(Integer index, String question, String answer) {
        this.index = index;
        this.question = question;
        this.answer = answer;
    }

    public QA() {

    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
