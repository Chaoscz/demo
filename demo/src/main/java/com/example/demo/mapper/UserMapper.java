package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;
@Mapper
public interface UserMapper {
	
	@Insert("insert into user(userName,age) values(#{userName},#{age})")
	public int saveUser(User user);
	@Select("select * from user where userId = #{userId}")
	public User getUserById(int userId);
}
