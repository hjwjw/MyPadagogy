package com.chinesepw.mapper;

import com.chinesepw.po.User;

public interface UserMapper {
	
	User loginUser(String userName,String password);
	
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}