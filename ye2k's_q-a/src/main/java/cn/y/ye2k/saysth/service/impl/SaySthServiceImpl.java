package cn.y.ye2k.saysth.service.impl;

import cn.y.ye2k.saysth.mapper.SaySthMapper;
import cn.y.ye2k.pojo.SaySth;
import cn.y.ye2k.saysth.service.SaySthService;
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
