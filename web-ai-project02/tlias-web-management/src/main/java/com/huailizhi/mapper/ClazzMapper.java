package com.huailizhi.mapper;

import com.huailizhi.pojo.Clazz;
import com.huailizhi.pojo.ClazzQueryParam;
import com.huailizhi.pojo.StudentCount;
import com.huailizhi.pojo.DegreeCount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> getPageResult(ClazzQueryParam clazzQueryParam);

    void addClazz(Clazz clazz);

    @Select("select * from clazz where id = #{id}")
    Clazz getClazzById(Integer id);

    void updateClazzById(Clazz clazz);

    @Delete("delete from clazz where id = #{id} ")
    void deleteClazzById(Integer id);

    @Select("select count(*) from student where clazz_id = #{id}")
    Integer countByClazzId(Integer id);

    @Select("select * from clazz")
    List<Clazz> list();

    List<StudentCount> countEveryClazz();

    List<DegreeCount> countEveryDegree();
}
