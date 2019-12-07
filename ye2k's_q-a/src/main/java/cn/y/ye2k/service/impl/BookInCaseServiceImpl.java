package cn.y.ye2k.service.impl;

import cn.y.ye2k.mapper.BookInCaseMapper;
import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookInCase;
import cn.y.ye2k.service.BookInCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInCaseServiceImpl implements BookInCaseService {

    @Autowired
    BookInCaseMapper bookInCaseMapper;

    @Override
    public List<BookInCase> findBooksByCase(String type) {
        List<BookInCase> bookInCases = bookInCaseMapper.findBooksByType(type);
        return bookInCases;
    }

    @Override
    public List<BookCaseChapter> findChapterByBid(Integer bid) {
        List<BookCaseChapter> bookCaseChapters = bookInCaseMapper.findBooksByBid(bid);
        return bookCaseChapters;
    }

    @Override
    public void addChapterToBook(BookCaseChapter bcc) {
        bookInCaseMapper.addChapterToBook(bcc);
    }
}
