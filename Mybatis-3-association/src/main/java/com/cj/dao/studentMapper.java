package com.cj.dao;

import com.cj.pojo.student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface studentMapper {

    public List<student> getStudent();
}
