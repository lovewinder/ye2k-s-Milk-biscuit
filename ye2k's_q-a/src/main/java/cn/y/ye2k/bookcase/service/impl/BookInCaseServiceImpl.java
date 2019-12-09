package cn.y.ye2k.bookcase.service.impl;

import cn.y.ye2k.bookcase.mapper.BookInCaseMapper;
import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookCaseSection;
import cn.y.ye2k.pojo.BookInCase;
import cn.y.ye2k.bookcase.service.BookInCaseService;
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
    public void addChapterToBook(BookCaseChapter bcc) {
        bookInCaseMapper.addChapterToBook(bcc);
    }

    @Override
    public List<BookCaseChapter> showChapter(Integer bid) {
        List<BookCaseChapter> bccs = bookInCaseMapper.showChapter(bid);
        for (int i = 0; i < bccs.size(); i++) {
            Integer count = bookInCaseMapper.countSection(bccs.get(i).getCid());
            bccs.get(i).setContainSections(count);
        }
        return bccs;

    }

    @Override
    public List<BookCaseSection> showSection(Integer cid) {
        List<BookCaseSection> bcss = bookInCaseMapper.showSection(cid);
        return bcss;

    }

    @Override
    public String findMdUrlBySid(Integer sid) {
        String url = bookInCaseMapper.findMdUrlBySid(sid);
        return url;

    }

    @Override
    public void addSection(BookCaseSection section) {
        bookInCaseMapper.addSection(section);
    }
}
