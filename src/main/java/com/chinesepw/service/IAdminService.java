package com.chinesepw.service;

import java.util.List;

import com.chinesepw.po.Admin;

public interface IAdminService {
	public List<Admin> queryAll();
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(Admin record);
    /*选择性插入*/
    public int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);
    //	选择性更新
    public int updateByPrimaryKeySelective(Admin record);

    public int updateByPrimaryKey(Admin record);
}
