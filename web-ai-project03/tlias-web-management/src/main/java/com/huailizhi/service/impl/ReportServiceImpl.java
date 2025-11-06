package com.huailizhi.service.impl;

import com.huailizhi.mapper.ClazzMapper;
import com.huailizhi.mapper.EmpMapper;
import com.huailizhi.pojo.JobOption;
import com.huailizhi.pojo.StudentCount;
import com.huailizhi.pojo.DegreeCount;
import com.huailizhi.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> list = empMapper.countEmpJobData();

        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("position")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    /*
    * 查询员工性别数量
    * */
    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public Map<String, Object> getStudentCountData() {
        List<StudentCount> studentCountList = clazzMapper.countEveryClazz();
        List<String> clazzList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        for (StudentCount studentCount : studentCountList) {
            clazzList.add(studentCount.getClazzName());
            dataList.add(studentCount.getStudentCount());
        }

        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("clazzList", clazzList);
        dataMap.put("dataList", dataList);

        return dataMap;
    }

    @Override
    public List<Map<String, Object>> getDegreeCount() {
        List<DegreeCount> degreeCountList = clazzMapper.countEveryDegree();
        List<Map<String, Object>> dataMap = new ArrayList<>();

        for (DegreeCount degreeCount : degreeCountList) {
            Map<String, Object> degreeCountMap = new HashMap<>();
            degreeCountMap.put("name", degreeCount.getDegreeName());
            degreeCountMap.put("value", degreeCount.getDegreeCount());

            dataMap.add(degreeCountMap);
        }

        return dataMap;
    }
}
