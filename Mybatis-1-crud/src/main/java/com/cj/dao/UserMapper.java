package com.cj.dao;

import com.cj.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User>  selectUser();

    List<User>  select_page_user(Map<String,Integer> map);
    User selectUser_name(String name);
    int add_user(User user);
    int delete_user(String name);
    int update_user(User user);
}
