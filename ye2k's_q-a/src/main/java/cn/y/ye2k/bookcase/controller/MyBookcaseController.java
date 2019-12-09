package cn.y.ye2k.bookcase.controller;

import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookCaseSection;
import cn.y.ye2k.pojo.BookInCase;
import cn.y.ye2k.pojo.ResultInfo;
import cn.y.ye2k.bookcase.service.BookInCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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


    @RequestMapping("showChapter")
    @ResponseBody
    public ResultInfo showChapter(Integer bid) {
        ResultInfo resultInfo = null;
        try {
            List<BookCaseChapter> bccs = bookInCaseService.showChapter(bid);
            resultInfo = new ResultInfo(true, bccs, null);
        } catch (Exception e) {
            resultInfo = new ResultInfo(false, null, "服务器异常");
        }
        return resultInfo;
    }

    @RequestMapping("showSection")
    @ResponseBody
    public ResultInfo showSection(Integer cid) {
        ResultInfo resultInfo = null;
        try {
            List<BookCaseSection> bcss = bookInCaseService.showSection(cid);
            resultInfo = new ResultInfo(true, bcss, null);
        } catch (Exception e) {
            resultInfo = new ResultInfo(false, null, "服务器异常");
        }
        return resultInfo;
    }

    @RequestMapping("findMdUrlBySid")
    @ResponseBody
    public ResultInfo findMdUrlBySid(Integer sid) {
        ResultInfo resultInfo = null;
        try {
            String url = bookInCaseService.findMdUrlBySid(sid);
            resultInfo = new ResultInfo(true, url, null);
        } catch (Exception e) {
            resultInfo = new ResultInfo(false, null, "服务器异常");
        }
        return resultInfo;
    }


    @RequestMapping("addSection")
    @ResponseBody
    public ResultInfo addSection(Integer cid, String createTime, String sectionName, String mdurl, MultipartFile file) {
        ResultInfo resultInfo = null;
        BookCaseSection section = new BookCaseSection(sectionName, cid, createTime, mdurl);
        try {
            bookInCaseService.addSection(section);

//            String originalFilename = file.getOriginalFilename();
//            String fileBaseName = FilenameUtils.getBaseName(originalFilename);
//            try {
//                //创建要上传的路径
//                File fdir = new File("D:/file");
//                if (!fdir.exists()) {
//                    fdir.mkdirs();
//                }
//                File newFile = new File("d:/aaa.md");
//                //文件上传到路径下
//                file.transferTo(newFile);
//
            resultInfo = new ResultInfo(true, null, null);
//            } catch (Exception e) {
//                resultInfo = new ResultInfo(false, null, "文件上传出现错误");
//            }
        } catch (Exception e) {
            resultInfo = new ResultInfo(false, null, "服务器异常");
        }
        return resultInfo;

    }


    @RequestMapping("addSectionFile")
    @ResponseBody
    public ResultInfo addSectionFile(@RequestParam("dir") String dir, @RequestParam("mdurl") String mdurl, @RequestParam("file") MultipartFile file) {
        ResultInfo resultInfo = null;
        try {
            String path = MyBookcaseController.class.getResource("/").getPath();
            String path2 = path.replace("/WEB-INF/classes/", "");
            String fileName = file.getOriginalFilename();
            // path2 = path2.replaceFirst("/","");
            path2 = path2+mdurl;
            File tempdir = new File(path2);

            if (!tempdir.exists()) {
                tempdir.mkdirs();
            }
           File newFile = new File(path2);
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                resultInfo = new ResultInfo(false, null, "文件传输错误");
            }
        } catch (Exception e) {
            resultInfo = new ResultInfo(false, null, "服务器繁忙");
        }
        System.out.println(file);
        System.out.println(mdurl);
        return resultInfo;

    }
}