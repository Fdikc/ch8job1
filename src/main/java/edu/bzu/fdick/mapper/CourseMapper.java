package edu.bzu.fdick.mapper;
import java.util.Date;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.bzu.fdick.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper extends BaseMapper<Course>{

  List<Course> selectAll();

  Course searchById(@Param("id") int id);

  //根据时间范围查询
//    List<Course> searchByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);


  List<Course> searchByCreateTimeBetween(@Param("beginCreateTime") Date beginCreateTime, @Param("endCreateTime") Date endCreateTime);


  int insertAll(Course course);

  int delById(@Param("id") int id);



}
