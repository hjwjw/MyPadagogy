package com.chinesepw.service;

import java.util.List;

import com.chinesepw.po.AdminUser;

public interface IAdminService {
	public List<AdminUser> queryAll();
	
	AdminUser loginUser(AdminUser adminUser);
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(AdminUser record);
    /*选择性插入*/
    public int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer id);
    //	选择性更新
    public int updateByPrimaryKeySelective(AdminUser record);

    public int updateByPrimaryKey(AdminUser record);
}
