package com.huailizhi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huailizhi.mapper.StudentMapper;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.pojo.Student;
import com.huailizhi.pojo.StudentQueryParam;
import com.huailizhi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> getPageResult(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

        List<Student> studentList = studentMapper.getPageResult(studentQueryParam);

        Page<Student> p = (Page<Student>) studentList;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void addStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);
        studentMapper.addStudent(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public void updateStudentById(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudentById(student);
    }

    @Override
    public void deleteStudentsByIds(List<Integer> ids) {
        studentMapper.deleteStudentsByIds(ids);
    }
}
