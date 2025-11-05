package com.huailizhi.controller;

import com.huailizhi.pojo.LogQueryParam;
import com.huailizhi.pojo.OperateLog;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.pojo.Result;
import com.huailizhi.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/log")
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    @GetMapping("/page")
    public Result getPageResult(LogQueryParam logQueryParam){
        log.info("分页查询:{}", logQueryParam);
        PageResult<OperateLog> operateLogList = operateLogService.getPageResult(logQueryParam);
        return Result.success(operateLogList);
    }
}
