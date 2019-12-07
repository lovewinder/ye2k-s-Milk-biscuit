package cn.y.ye2k.service;

import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookInCase;

import java.util.List;

public interface BookInCaseService {

    List<BookInCase> findBooksByCase(String type);

    List<BookCaseChapter> findChapterByBid(Integer bid);

    void addChapterToBook(BookCaseChapter bcc);
}
