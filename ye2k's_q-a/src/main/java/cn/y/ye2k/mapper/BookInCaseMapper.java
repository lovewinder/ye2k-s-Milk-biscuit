package cn.y.ye2k.mapper;

import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookCaseSection;
import cn.y.ye2k.pojo.BookInCase;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BookInCaseMapper extends Mapper<BookInCase> {

    List<BookInCase> findBooksByType(@Param("type") String type);

    void addChapterToBook(BookCaseChapter bcc);

    List<BookCaseChapter> showChapter(@Param("bid") Integer bid);

    Integer countSection(@Param("cid") Integer cid);

    List<BookCaseSection> showSection(Integer cid);

    String findMdUrlBySid(@Param("sid")Integer sid);

    void addSection(BookCaseSection section);
}
