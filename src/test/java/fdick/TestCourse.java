package fdick;
import edu.bzu.fdick.entity.Course;
import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.mapper.CourseMapper;
import edu.bzu.fdick.mapper.UserMapper;
import edu.bzu.fdick.service.CourseService;
import edu.bzu.fdick.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class TestCourse {

    @Test
    public void test2Course() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CourseMapper CourseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = CourseMapper.selectList(null);
        for (Course course : courses) {
            System.out.println(course);
        }
    }
    @Test
    public void test1Course() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CourseMapper CourseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = CourseMapper.selectAll();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void testIdCourse() {
        CourseService courseService = new CourseService();
        Course course = courseService.getCourseById(8);

        System.out.println(course);
    }

    @Test
    public void testtimeCourse() throws ParseException {
        CourseService courseService = new CourseService();
        List<Course> courses = courseService.getCourseByTime("2018-06-10", "2019-06-13");


//        List<Course> courses = courseService.getCourseByTime(parse, parse1);

        System.out.println(courses);
    }

    @Test
    public void testnewtimeCourse() throws ParseException {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
    }

    @Test
    public void insertCourse() {
        Course course = new Course();
        course.setCouname("ja111va");

       course.setMiaoshu("hhhhhh111hh");
       course.setTeacher("fdick111");
        CourseService courseService = new CourseService();
        boolean b = courseService.insertCourse(course);
        System.out.println(b);

    }
    @Test
    public void delCourse() {

        CourseService courseService = new CourseService();
        boolean b = courseService.delCourse(13);


        System.out.println(b);

    }
    @Test
    public void seluser() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("r", "r1");

        User user1 = userMapper.searchByUsernameAndPassword(user);


        System.out.println(user1);

    }
}
