package cn.y.ye2k.saysth.service;

import cn.y.ye2k.pojo.SaySth;

import java.util.List;

public interface SaySthService {

    List<SaySth> findSaySth();

    void addSth(SaySth ss);
}
