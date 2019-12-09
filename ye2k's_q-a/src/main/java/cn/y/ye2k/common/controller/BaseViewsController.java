package cn.y.ye2k.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author ye2k's look-up 内测小组
 * @date 2019-12-08
 */

@Controller
public class BaseViewsController {
    @RequestMapping("{page}")
    public String main(@PathVariable String page){
        return page;
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}

