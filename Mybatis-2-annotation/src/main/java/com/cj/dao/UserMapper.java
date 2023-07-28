package com.cj.dao;
import com.cj.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;


public interface UserMapper {
    @Select("select * from nba2k;")
    List<User>  selectUser();
    @Select("select * from nba2k where name=#{name}")
    User selectUser_name(@Param("name") String name);
    @Insert("insert into nba2k(id,name,age,k_value) values(#{id},#{name},#{age},#{k_value})")
    int add_user(User user);
    @Delete("delete from nba2k where id=#{id}")
    int delete_user(@Param("id") int id);
    @Update("update nba2k set name=#{name},id=#{id},age=#{age},k_value=#{k_value} where id=#{id}")
    int update_user(User user);
}
