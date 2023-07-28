import com.cj.dao.studentMapper;
import com.cj.pojo.student;
import com.cj.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class associationTest {
    @Test
    public void getStudent(){
        SqlSession sqlSession= mybatisUtils.getSession();
        studentMapper mapper=sqlSession.getMapper(studentMapper.class);
        List<student> students=mapper.getStudent();
        for(student student:students)
            System.out.println(student);
    }

}
