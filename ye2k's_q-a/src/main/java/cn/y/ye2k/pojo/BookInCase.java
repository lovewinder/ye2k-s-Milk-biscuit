package cn.y.ye2k.pojo;

import cn.y.ye2k.common.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 书柜
 *
 * @author ye2k's look-up 内测小组
 * @date 2019-12
 */

@Table(name = "tab_bookCase")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInCase {
    @Id
    @GeneratedValue(generator = "JDBC")
    /**
     * 用户id
     */
    private Integer bid;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 书籍类型
     */
    private String type;

}
