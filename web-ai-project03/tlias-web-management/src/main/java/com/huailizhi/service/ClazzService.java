package com.huailizhi.service;

import com.huailizhi.pojo.Clazz;
import com.huailizhi.pojo.ClazzQueryParam;
import com.huailizhi.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> getPageResult(ClazzQueryParam clazzQueryParam);

    void addClazz(Clazz clazz);

    Clazz getClazzById(Integer id);

    void updateClazzById(Clazz clazz);

    void deleteClazzById(Integer id);

    List<Clazz> list();
}
