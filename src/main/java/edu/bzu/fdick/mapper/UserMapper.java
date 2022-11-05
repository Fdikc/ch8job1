package edu.bzu.fdick.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.bzu.fdick.entity.Course;
import edu.bzu.fdick.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMapper extends BaseMapper<User>{


  User searchByUsernameAndPassword(User user);





}
