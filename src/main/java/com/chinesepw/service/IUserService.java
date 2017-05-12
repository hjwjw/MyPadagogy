package com.chinesepw.service;

import java.util.List;

import com.chinesepw.po.AdminUser;
import com.chinesepw.po.User;

/**
 * @author HJW
 * @date 2017年5月1日
 * 
 */
public interface IUserService {
	
	User loginUser(String userName,String password);
	
    public int deleteByPrimaryKey(Integer userId);

    public int insertSelective(User record);

    public User selectByPrimaryKey(Integer userId);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);
}
