package cn.y.ye2k.common.controller;

import cn.y.ye2k.pojo.QA;
import cn.y.ye2k.pojo.ResultInfo;
import cn.y.ye2k.common.utils.Question_Answer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("qa")
public class QAController {
    @RequestMapping("loadContent")
    @ResponseBody
    public ResultInfo loadContent(String type, HttpServletResponse response) throws IOException {
        ResultInfo resultInfo;
        response.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1 * 1000);
        Map<Map<Integer,String>,Map<Integer,String>> errMap = new HashMap<>();
        try {
            String path = QAController.class.getResource("/").getPath();
            String strq = Question_Answer.readTxt(path.replace("/WEB-INF/classes/", "/txt/question/" + type + ".txt"));
            String stra = Question_Answer.readTxt(path.replace("/WEB-INF/classes/", "/txt/answer/" + type + ".txt"));
            Map<String, String> tmap = new HashMap<>();
            Map<Integer, String> mapq = Question_Answer.parseQA(strq);
            Map<Integer, String> mapa = Question_Answer.parseQA(stra);

            errMap.put(mapq,mapa);

            List<QA> lis = new ArrayList<>();
            mapq.forEach((key, value) -> {
                QA qa = new QA();
                qa.setIndex(key);
                qa.setQuestion(value);
                qa.setAnswer(mapa.get(key));
                lis.add(qa);
            });

            resultInfo = new ResultInfo(true, lis, null);
            return resultInfo;
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, errMap, "服务器忙,请稍后再试...2");
            return resultInfo;
        }
    }
}