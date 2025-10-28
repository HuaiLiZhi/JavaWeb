package com.huailizhi.service;

import com.huailizhi.pojo.Clazz;
import com.huailizhi.pojo.ClazzQueryParam;
import com.huailizhi.pojo.PageResult;

public interface ClazzService {
    PageResult<Clazz> list(ClazzQueryParam clazzQueryParam);
}
