package cn.y.ye2k.bookcase.service;

import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookCaseSection;
import cn.y.ye2k.pojo.BookInCase;

import java.util.List;

public interface IBookInCaseService {

    List<BookInCase> findBooksByCase(String type);

    void addChapterToBook(BookCaseChapter bcc);

    List<BookCaseChapter> showChapter(Integer bid);

    List<BookCaseSection> showSection(Integer cid);

    String findMdUrlBySid(Integer sid);

    void addSection(BookCaseSection section);
}
