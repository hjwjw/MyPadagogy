package com.chinesepw.service;

import java.util.List;

import com.chinesepw.po.Apptypelist;

/**
 * @author HJW
 * @date 2017年5月1日
 * 
 */
public interface IApptypelistService {
	
	public List<Integer> getTypeListByAppId(Integer appId);
	
	public List<Integer> getAppListByTypeId(Integer typeId);
	
    public int deleteByappId(Integer appId);
    
    public int deleteBytypeId(Integer typeId);
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(Apptypelist record);

    public int insertSelective(Apptypelist record);

    public Apptypelist selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Apptypelist record);

    public int updateByPrimaryKey(Apptypelist record);
}
