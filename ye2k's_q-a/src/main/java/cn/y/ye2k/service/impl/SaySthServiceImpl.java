package cn.y.ye2k.service.impl;

import cn.y.ye2k.mapper.BookInCaseMapper;
import cn.y.ye2k.mapper.SaySthMapper;
import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookCaseSection;
import cn.y.ye2k.pojo.BookInCase;
import cn.y.ye2k.pojo.SaySth;
import cn.y.ye2k.service.BookInCaseService;
import cn.y.ye2k.service.SaySthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaySthServiceImpl implements SaySthService {

    @Autowired
    SaySthMapper saySthMapper;


    @Override
    public List<SaySth> findSaySth() {
        List<SaySth> ss = saySthMapper.querySaySth();
        return ss;
    }

    @Override
    public void addSth(SaySth ss) {
        saySthMapper.addSth(ss.getContent(), ss.getCreateTime());
    }
}
