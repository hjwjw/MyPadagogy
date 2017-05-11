package com.chinesepw.mapper;

import java.util.List;

import com.chinesepw.po.Appitem;
import com.chinesepw.po.AppitemCustom;

public interface AppitemMapper {
	List<AppitemCustom> queryAll();
	
	List<AppitemCustom> queryAllOrderByCount();
	
	List<AppitemCustom> queryPending();
	
    int deleteByPrimaryKey(Integer appId);

    int insert(Appitem record);

    int insertSelective(Appitem record);

    Appitem selectByPrimaryKey(Integer appId);

    int updateByPrimaryKeySelective(Appitem record);

    int updateByPrimaryKeyWithBLOBs(Appitem record);

    int updateByPrimaryKey(Appitem record);
}