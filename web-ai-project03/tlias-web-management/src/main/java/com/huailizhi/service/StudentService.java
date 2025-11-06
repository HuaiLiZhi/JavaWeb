package com.huailizhi.service;

import com.huailizhi.pojo.PageResult;
import com.huailizhi.pojo.Student;
import com.huailizhi.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> getPageResult(StudentQueryParam studentQueryParam);

    void addStudent(Student student);

    Student getStudentById(Integer id);

    void updateStudentById(Student student);

    void deleteStudentsByIds(List<Integer> ids);

    void violation(Integer id, Short score);
}
