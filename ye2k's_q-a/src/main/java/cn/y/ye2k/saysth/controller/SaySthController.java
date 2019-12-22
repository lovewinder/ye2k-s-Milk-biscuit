package cn.y.ye2k.saysth.controller;

import cn.y.ye2k.pojo.ResultInfo;
import cn.y.ye2k.pojo.SaySth;
import cn.y.ye2k.saysth.service.SaySthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("saySth")
public class SaySthController {

    @Autowired
    SaySthService saySthService;

    @RequestMapping("queryRandom11")
    @ResponseBody
    public ResultInfo loadContent( HttpServletResponse response) throws IOException {
        ResultInfo resultInfo;
        // response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);

        try {
            List<SaySth> lis = saySthService.findSaySth();
            if (lis.size() == 0) {
                resultInfo = new ResultInfo(true, null, "暂无数据");
                return resultInfo;
            }
            int num = lis.size() > 11 ? 11 : lis.size();
            List<SaySth> tlis = new ArrayList<>();
            List<Integer> removeHas = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                int random = (int) (Math.random() * lis.size());
                if (removeHas.indexOf(random) == -1) {
                    removeHas.add(random);
                    tlis.add(lis.get(random));
                }
            }
            resultInfo = new ResultInfo(true, tlis, null);
            return resultInfo;
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器忙,请稍后再试...");
            return resultInfo;
        }
    }

    @RequestMapping("addSth")
    @ResponseBody
    public ResultInfo addContent(@RequestParam ("content") String content, String createTime, HttpServletResponse response) throws IOException {
        ResultInfo resultInfo;
        response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);

        try {
            SaySth ss = new SaySth(content, createTime);
            saySthService.addSth(ss);
            resultInfo = new ResultInfo(true, null, null);
            return resultInfo;
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器忙,请稍后再试...");
            return resultInfo;
        }
    }
}