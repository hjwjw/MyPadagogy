package com.chinesepw.mapper;

import java.util.List;

import com.chinesepw.po.Apptypelist;

public interface ApptypelistMapper {
	
	List<Integer> getTypeListByAppId(Integer appId);
	
	List<Integer> getAppListByTypeId(Integer typeId);
	
    int deleteByappId(Integer appId);
    
    int deleteBytypeId(Integer typeId);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Apptypelist record);

    int insertSelective(Apptypelist record);

    Apptypelist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apptypelist record);

    int updateByPrimaryKey(Apptypelist record);
}