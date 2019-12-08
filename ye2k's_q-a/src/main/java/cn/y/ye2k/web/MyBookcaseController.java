package cn.y.ye2k.web;

import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookInCase;
import cn.y.ye2k.pojo.ResultInfo;
import cn.y.ye2k.service.BookInCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("myBookcase")
public class MyBookcaseController {

    @Autowired
    BookInCaseService bookInCaseService;

    @RequestMapping("showBooks")
    @ResponseBody
    public ResultInfo showBooks(String type) {
        ResultInfo resultInfo = null;
        try {
            List<BookInCase> booksByCase = bookInCaseService.findBooksByCase(type);
            resultInfo = new ResultInfo(true, booksByCase, null);
        } catch (Exception e) {
            resultInfo = new ResultInfo(false, null, "服务器异常");
        }
        return resultInfo;
    }

    @RequestMapping("showBooksByBid")
    @ResponseBody
    public ResultInfo showBooksByBid(Integer bid) {
        ResultInfo resultInfo = null;
        try {
            List<BookCaseChapter> bookCaseChapters = bookInCaseService.findChapterByBid(bid);
            resultInfo = new ResultInfo(true, bookCaseChapters, null);
        } catch (Exception e) {
            resultInfo = new ResultInfo(false, null, "服务器异常");
        }
        return resultInfo;
    }


    @RequestMapping("addChapterToBook")
    @ResponseBody
    public ResultInfo addChapterToBook(BookCaseChapter bcc, Integer bid) {
        ResultInfo resultInfo = null;
        try {
            bcc.setBid(bid);
            bookInCaseService.addChapterToBook(bcc);
            resultInfo = new ResultInfo(true, null, null);
        } catch (Exception e) {
            resultInfo = new ResultInfo(false, null, "服务器异常");
        }
        return resultInfo;
    }

}
