package cn.y.ye2k.saysth.mapper;

import cn.y.ye2k.pojo.SaySth;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SaySthMapper extends Mapper<SaySth> {

    List<SaySth> querySaySth();

    void addSth(@Param("content") String content, @Param("createTime") String createTime);
}
