package com.chinesepw.mapper;

import java.util.List;

import com.chinesepw.po.AdminUser;

public interface AdminUserMapper {
	List<AdminUser> queryAll();
	
	AdminUser loginUser(AdminUser adminUser);
	
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}