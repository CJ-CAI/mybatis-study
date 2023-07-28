package com.cj.dao;
import com.cj.pojo.User;
import com.cj.utils.mybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    static Logger logger=Logger.getLogger(UserMapperTest.class);
    @Test
    public void constructor_test() throws NoSuchFieldException, IllegalAccessException {
        User user=new User();
        Class user_class=user.getClass();
        Field name=user_class.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user,"reflect");
        System.out.println(user.getName());
    }
    @Test
    public void getUser_page_test(){
        SqlSession sqlSession=mybatisUtils.getSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int currentPage=1;
        int pageSize=4;
        Map<String, Integer> limit=new HashMap<String,Integer>();
        limit.put("startIndex",(currentPage-1)*pageSize);
        limit.put("pageIndex",pageSize);
        List<User> users=mapper.select_page_user(limit);
        sqlSession.close();
        for(User user: users)
            System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void getUser_test(){
        try {
            logger.info("查询所有用户");
            logger.debug("查询所有用户");
            SqlSession sqlSession = mybatisUtils.getSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            RowBounds rowBounds = new RowBounds(2,2);
//            List<User> users =sqlSession.selectList("com.cj.dao.UserMapper.selectUser",null,rowBounds);
            List<User> users=mapper.selectUser();
            for(User user: users)
                System.out.println(user);
            sqlSession.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void  getUser_name_test(){
        try {
        SqlSession sqlSession=mybatisUtils.getSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.selectUser_name("nk");
        System.out.println(user);
        sqlSession.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    @Test
    public void  add_user(){
        try {
            SqlSession sqlSession=mybatisUtils.getSession();
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            User user=new User(13,"Harden",33,97);
            mapper.add_user(user);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Test
    public void  update_user(){
        try {
            SqlSession sqlSession=mybatisUtils.getSession();
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            User user=new User(13,"Harden",33,97);
            mapper.update_user(user);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Test
    public void  delete_user(){
        try {
            SqlSession sqlSession=mybatisUtils.getSession();
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            mapper.delete_user("james");
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}