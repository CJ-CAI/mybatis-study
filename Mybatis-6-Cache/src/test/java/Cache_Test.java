import com.cj.Utils.mybatisUtils;
import com.cj.dao.BlogMapper;
import com.cj.pojo.Blog;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Cache_Test {
    @Test
    public void get_blogs(){
        SqlSession sqlSession1= mybatisUtils.getSession();
        SqlSession sqlSession2= mybatisUtils.getSession();
        BlogMapper mapper=sqlSession1.getMapper(BlogMapper.class);
        List<Blog> blogs=mapper.getBlogs();
        for(Blog blog:blogs)
            System.out.println(blog);
        System.out.println(sqlSession2==sqlSession1);
        BlogMapper mapper2=sqlSession2.getMapper(BlogMapper.class);
        List<Blog> blogs2=mapper2.getBlogs();
        for(Blog blog:blogs2)
            System.out.println(blog);
    }
}
