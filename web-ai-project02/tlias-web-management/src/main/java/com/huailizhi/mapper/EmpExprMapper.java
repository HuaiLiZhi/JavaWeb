package com.huailizhi.mapper;

import com.huailizhi.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /*
    * 批量保存工作经历信息
    * */

    void insertBatch(@Param("exprList") List<EmpExpr> exprList);
}
