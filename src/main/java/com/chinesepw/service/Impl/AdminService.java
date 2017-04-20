package com.chinesepw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinesepw.mapper.AdminMapper;
import com.chinesepw.po.Admin;
import com.chinesepw.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private AdminMapper adminMapper; 
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return adminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Admin record) {
		return adminMapper.insert(record);
	}

	@Override
	public int insertSelective(Admin record) {
		return adminMapper.insertSelective(record);
	}

	@Override
	public Admin selectByPrimaryKey(Integer id) {
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Admin record) {
		return adminMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Admin record) {
		return adminMapper.updateByPrimaryKey(record);
	}

}
