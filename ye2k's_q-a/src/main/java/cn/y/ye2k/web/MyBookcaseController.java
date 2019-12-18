package cn.y.ye2k.web;

import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookCaseSection;
import cn.y.ye2k.pojo.BookInCase;
import cn.y.ye2k.pojo.ResultInfo;
import cn.y.ye2k.service.BookInCaseService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
    public ResultInfo showBooks(String type, HttpServletResponse response) {
        ResultInfo resultInfo = null;
        // response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);
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
    public ResultInfo addChapterToBook(BookCaseChapter bcc, Integer bid, HttpServletResponse response) {
        ResultInfo resultInfo = null;
        // response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);
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
    public ResultInfo showChapter(Integer bid, HttpServletResponse response) {
        ResultInfo resultInfo = null;
        //  response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);
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
    public ResultInfo showSection(Integer cid, HttpServletResponse response) {
        ResultInfo resultInfo = null;
        // response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);
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
    public ResultInfo findMdUrlBySid(Integer sid, HttpServletResponse response) {
        // response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);
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
    public ResultInfo addSection(Integer cid, String createTime, String sectionName, String mdurl, MultipartFile file, HttpServletResponse response) {
        ResultInfo resultInfo = null;
        //response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);
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
    public ResultInfo addSectionFile(@RequestParam("dir") String dir, @RequestParam("mdurl") String mdurl, @RequestParam("file") MultipartFile file, HttpServletResponse response) {
        ResultInfo resultInfo = null;
        // response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);
        try {
            String path = MyBookcaseController.class.getResource("/").getPath();
            String path2 = path.replace("/WEB-INF/classes/", "");
            String fileName = file.getOriginalFilename();
            // path2 = path2.replaceFirst("/","");
            String pathMd = "/home/ubuntu/ye2k/mybookcase";
            path2 = path2 + mdurl;
            pathMd = pathMd + mdurl;
            File tempdir = new File(pathMd);
            File tempdirOut = new File(path2);

            if (!tempdir.exists()) {
                tempdir.mkdirs();
            }
            if (!tempdirOut.exists()) {
                tempdirOut.mkdirs();
            }
            File newFile = new File(pathMd);
            File newFileOut = new File(path2);

            try {
                file.transferTo(newFile);
                file.transferTo(newFileOut);
            } catch (IOException e) {
                resultInfo = new ResultInfo(false, null, "文件传输错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器繁忙");
        }
        System.out.println(file);
        System.out.println(mdurl);
        return resultInfo;

    }
}