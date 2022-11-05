package edu.bzu.fdick.service;

import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.mapper.UserMapper;
import edu.bzu.fdick.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {



    /*
     * @Author FDC
     * @Date 2022/11/5 12:43
     * @Description 登录
     * @Param
     * @Return
     */

    public boolean login(User user){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1= userMapper.searchByUsernameAndPassword(user);
        if (user1!=null){
            return true;
        }
        return false;
    }



}
