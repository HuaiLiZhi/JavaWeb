package com.huailizhi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huailizhi.exception.ClazzHasStudentsException;
import com.huailizhi.mapper.ClazzMapper;
import com.huailizhi.pojo.Clazz;
import com.huailizhi.pojo.ClazzQueryParam;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> getPageResult(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        List<Clazz> clazzList = clazzMapper.getPageResult(clazzQueryParam);

        LocalDate now = LocalDate.now();
        for (Clazz clazz : clazzList) {
            LocalDate beginDate = clazz.getBeginDate();
            LocalDate endDate = clazz.getEndDate();
            if (now.isBefore(beginDate)){
                clazz.setStatus("未开班");
            } else if (now.isAfter(beginDate) && now.isBefore(endDate)) {
                clazz.setStatus("已开班");
            } else {
                clazz.setStatus("已结课");
            }
        }

        Page<Clazz> p = (Page<Clazz>) clazzList;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazz(clazz);
    }

    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.getClazzById(id);
    }

    @Override
    public void updateClazzById(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateClazzById(clazz);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteClazzById(Integer id) {
        Integer count = clazzMapper.countByClazzId(id);
        if (count > 0){
            throw new ClazzHasStudentsException();
        }
        clazzMapper.deleteClazzById(id);
    }

    @Override
    public List<Clazz> list() {
        return clazzMapper.list();
    }
}
