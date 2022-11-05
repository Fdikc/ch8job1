# Experment_fdick
## 课程管理系统

#### 基于mybatis+servlet(Maven方式构建)

[![Build Status](https://fdick-1312693144.cos.ap-beijing.myqcloud.com/Fdick/img/202211012228722.svg)](https://github.com/Fdikc/Experment_fdick)
[![Fdick.pm](https://fdick-1312693144.cos.ap-beijing.myqcloud.com/Fdick/img/202211012227736.svg)](![fdick](https://github.com/Fdikc/Experment_fdick))

### 项目简介

本系统基于Mybatis,Servlet,jsp。数据库为mysql。前端使用了Bootstrap。 

### 系统功能

1. 在IDEA中导入项目，将提供数据库文件直接导入mysql数据库；书籍图片存储在images目录下；

2. 编写浏览功能（index.jsp为浏览视图），根据需要完善CourseServlet、CourseDao类。

3. 编写详情功能（details.jsp为详情视图），在页面上显示课程详细信息，根据需要完善CourseDetailsServlet、CourseDao类。

4. 编写查询功能，查询开始时间和结束时间之间的记录 ，查询成功后显示查询结果，根据需要完善CourseSearchServlet、CourseDao类。

5.使用JSTL循环显示列表；

6.使用JSTL把显示日期转换为2020年8月4日；

7.使用JSTL国际化，显示浏览页表头，根据选择语言显示英文或中文如课程名英文为courseName;

8.使用JSTL自定义标签在详细显示时，如课程名中有JAVA则在课程名后显示英文教学。

9.编写一个登录页，用户登录成功，把用户信息存储到session中，访问浏览页时如果用户登录成功，显示增加和删除按钮，如不成功不显示按钮（使用jstl实现）。

### 如何使用

```
$ https://github.com/Fdikc/ch8job1.git
```

### 说明<br/>

1. 如果使用该项目出现问题，请联系我 cc_flipped@126.com
2. 如果该项目对您有帮助,请star鼓励我
