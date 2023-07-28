package com.cj.dao;

import com.cj.pojo.Blog;
import org.apache.ibatis.annotations.Select;

import javax.swing.plaf.PanelUI;
import java.util.List;

public interface BlogMapper {
    public List<Blog> getBlogs();
}

