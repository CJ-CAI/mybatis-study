package com.cj.dao;

import com.cj.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    public List<Blog> getBlogs();
    public int insertBlog(Blog blog);
    public List<Blog> queryBlog(Map map);
    public int updateBlog(Map map);
    public List<Blog> queryForeachBlog(Map map);
}
