import com.cj.dao.UserMapper;
import com.cj.pojo.User;
import com.cj.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class Annotation {
    static Logger logger=Logger.getLogger(Annotation.class);
    @Test
    public void select_test(){
        SqlSession sqlSession= mybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users=mapper.selectUser();
        for(User user : users)
            System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void select_name_test(){
        SqlSession sqlSession= mybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.selectUser_name("Harden");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void select_add_test(){
        SqlSession sqlSession= mybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User(23,"James",38,96);
        logger.info("增加用户结果为"+mapper.add_user(user1));
        select_test();
        sqlSession.close();
    }
    @Test
    public void select_update_test(){
        SqlSession sqlSession= mybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(45,"Mitchell",26,94);
        mapper.update_user(user);
        select_test();
        sqlSession.close();

    }
    @Test
    public void select_delete_test(){
        SqlSession sqlSession= mybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int id=23,flag;
        flag=mapper.delete_user(id);
        logger.info("删除结果为"+flag);
        select_test();
        sqlSession.close();

    }
}
