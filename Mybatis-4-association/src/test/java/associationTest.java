import com.cj.dao.teacherMapper;
import com.cj.pojo.teacher;
import com.cj.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class associationTest {
    @Test
    public void getTeachers(){
        SqlSession sqlSession= mybatisUtils.getSession();
        teacherMapper tMapper=sqlSession.getMapper(teacherMapper.class);
        List<teacher> teachers=tMapper.getTeachers();
        for(teacher teacher : teachers)
            System.out.println(teacher);
    }
}
