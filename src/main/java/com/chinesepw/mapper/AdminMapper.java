package com.chinesepw.mapper;

import java.util.List;

import com.chinesepw.po.Admin;

public interface AdminMapper {
	List<Admin> queryAll();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}