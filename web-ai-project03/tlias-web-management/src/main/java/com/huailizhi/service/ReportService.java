package com.huailizhi.service;

import com.huailizhi.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    Map<String, Object> getStudentCountData();

    List<Map<String, Object>> getDegreeCount();
}
