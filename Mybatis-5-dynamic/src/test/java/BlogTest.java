import com.cj.dao.BlogMapper;
import com.cj.pojo.Blog;
import com.cj.utils.ID_utility;
import com.cj.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogTest {
    SqlSession sqlSession= mybatisUtils.getSession();
    public BlogMapper getBlogMapper(){
        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
        return blogMapper;
    }
    @Test
    public void get_Blogs(){
        BlogMapper blogMapper=getBlogMapper();
        List<Blog> blogs=blogMapper.getBlogs();
        for (Blog blog : blogs)
            System.out.println(blog);
        sqlSession.close();
    }

    @Test
    public void insertBlog_Test(){
        BlogMapper blogMapper=getBlogMapper();
        Blog blog = new Blog();

        blog.setId(ID_utility.getID());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        blogMapper.insertBlog(blog);

        blog.setId(ID_utility.getID());
        blog.setTitle("Java如此简单");
        blogMapper.insertBlog(blog);

        blog.setId(ID_utility.getID());
        blog.setTitle("Spring如此简单");
        blogMapper.insertBlog(blog);

        blog.setId(ID_utility.getID());
        blog.setTitle("微服务如此简单");
        blogMapper.insertBlog(blog);
        sqlSession.close();
    }

    @Test
    public void queryBlog(){
        BlogMapper blogMapper=getBlogMapper();
        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("author","狂神说");
//        map.put("title","Java如此简单");
        List<Blog> blogs=blogMapper.queryBlog(map);
        for(Blog blog:blogs)
            System.out.println(blog);
    }
    @Test
    public void updateBlog(){
        BlogMapper blogMapper=getBlogMapper();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id","3a3731624e904153b730fcca1a19849a");
        map.put("author","阿德托昆博");
        map.put("title","JavaSE如此简单");
        blogMapper.updateBlog(map);
        get_Blogs();
    }
    @Test
    public void queryForeachBlog() {
        BlogMapper blogMapper = getBlogMapper();
        List<Integer> ids = new LinkedList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        HashMap map=new HashMap();
        map.put("ids",ids);
        List<Blog> blogs = blogMapper.queryForeachBlog(map);
        for (Blog blog : blogs)
            System.out.println(blog);
    }
}
