package cn.y.ye2k.mapper;

import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookInCase;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BookInCaseMapper extends Mapper<BookInCase> {

    List<BookInCase> findBooksByType(@Param("type") String type);

    List<BookCaseChapter> findBooksByBid(@Param("bid") Integer bid);

    void addChapterToBook(BookCaseChapter bcc);
}
