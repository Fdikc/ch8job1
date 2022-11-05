package edu.bzu.fdick.service;

import edu.bzu.fdick.entity.Course;
import edu.bzu.fdick.mapper.CourseMapper;
import edu.bzu.fdick.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CourseService {


    /*
     * @Author FDC
     * @Date 2022/11/4 19:59
     * @Description 查询所有课程
     * @Param []
     * @Return courses
     */
    public List<Course> getAllCourse() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CourseMapper CourseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = CourseMapper.selectAll();
        return courses;
    }


    /*
     * @Author FDC
     * @Date 2022/11/4 19:59
     * @Description 根据id查询课程
     * @Param [id]
     * @Return course
     */
    public Course getCourseById(int id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CourseMapper CourseMapper = sqlSession.getMapper(CourseMapper.class);
        Course course = CourseMapper.searchById(id);
        return course;
    }

    /*
     * @Author FDC
     * @Date 2022/11/4 19:59
     * @Description 根据时间范围查询课程
     * @Param [beginCreateTime, endCreateTime]
     * @Return courses
     */
    public List<Course> getCourseByTime(String beginCreateTime, String endCreateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = sdf.parse(beginCreateTime);
        Date parse2 = sdf.parse(endCreateTime);
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CourseMapper CourseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = CourseMapper.searchByCreateTimeBetween(parse1, parse2);
        return courses;
    }


    /*
     * @Author FDC
     * @Date 2022/11/4 23:03
     * @Description insertCourse
     * @Param [course]
     * @Return boolean
     */
   public boolean insertCourse(Course course) {
       Date date = new Date();
       course.setCreateTime(date);
       SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CourseMapper CourseMapper = sqlSession.getMapper(CourseMapper.class);
        int insert = CourseMapper.insert(course);
        if (insert > 0) {
            sqlSession.commit();
            return true;
        } else {
            sqlSession.rollback();
            return false;
        }
    }


    public boolean delCourse(int id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CourseMapper CourseMapper = sqlSession.getMapper(CourseMapper.class);
        int i = CourseMapper.delById(id);
        if (i > 0) {
            sqlSession.commit();
            return true;
        } else {
            sqlSession.rollback();
            return false;
        }
    }

}