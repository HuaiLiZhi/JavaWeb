package com.huailizhi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huailizhi.mapper.OperateLogMapper;
import com.huailizhi.pojo.LogQueryParam;
import com.huailizhi.pojo.OperateLog;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> getPageResult(LogQueryParam logQueryParam) {
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());

        List<OperateLog> operateLogList = operateLogMapper.getPageResult();

        Page<OperateLog> p = (Page<OperateLog>) operateLogList;

        return new PageResult<OperateLog>(p.getTotal(), p.getResult());

    }
}
