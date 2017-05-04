package com.chinesepw.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinesepw.mapper.AdminUserMapper;
import com.chinesepw.po.AdminUser;
import com.chinesepw.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private AdminUserMapper adminMapper; 
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return adminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(AdminUser record) {
		return adminMapper.insert(record);
	}

	@Override
	public int insertSelective(AdminUser record) {
		return adminMapper.insertSelective(record);
	}

	@Override
	public AdminUser selectByPrimaryKey(Integer id) {
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AdminUser record) {
		return adminMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AdminUser record) {
		return adminMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<AdminUser> queryAll() {
		return adminMapper.queryAll();
	}

}
