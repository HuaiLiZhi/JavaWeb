package com.huailizhi.service;

import com.huailizhi.pojo.LogQueryParam;
import com.huailizhi.pojo.OperateLog;
import com.huailizhi.pojo.PageResult;

public interface OperateLogService {
    PageResult<OperateLog> getPageResult(LogQueryParam logQueryParam);
}
