package cn.y.ye2k.service;

import cn.y.ye2k.pojo.BookCaseChapter;
import cn.y.ye2k.pojo.BookCaseSection;
import cn.y.ye2k.pojo.BookInCase;
import cn.y.ye2k.pojo.SaySth;

import java.util.List;

public interface SaySthService {

    List<SaySth> findSaySth();

    void addSth(SaySth ss);
}
