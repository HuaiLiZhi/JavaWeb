package com.huailizhi.mapper;

import com.huailizhi.pojo.Student;
import com.huailizhi.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> getPageResult(StudentQueryParam studentQueryParam);

    void addStudent(Student student);

    @Select("select * from student where id = #{id} ")
    Student getStudentById(Integer id);

    void updateStudentById(Student student);

    void deleteStudentsByIds(List<Integer> ids);
}
