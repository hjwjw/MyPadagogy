package com.chinesepw.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinesepw.mapper.AppitemMapper;
import com.chinesepw.po.Appitem;
import com.chinesepw.po.AppitemCustom;
import com.chinesepw.service.IAppItemService;

/**
 * @author HJW
 * @date 2017年4月23日
 * 
 */

@Service
public class AppItemService implements IAppItemService {
	@Autowired
	AppitemMapper appItemMapper;
	
	@Override
	public List<AppitemCustom> queryAll() {
		return appItemMapper.queryAll();
	}
	
	@Override
	public List<AppitemCustom> queryPending() {
		return appItemMapper.queryPending();
	}
	
	@Override
	public int deleteByPrimaryKey(Integer appId) {
		return appItemMapper.deleteByPrimaryKey(appId);
	}

	@Override
	public int insertSelective(Appitem record) {
		return appItemMapper.insertSelective(record);
	}

	@Override
	public Appitem selectByPrimaryKey(Integer appId) {
		return appItemMapper.selectByPrimaryKey(appId);
	}


	@Override
	public int updateByPrimaryKeyWithBLOBs(Appitem record) {
		return appItemMapper.updateByPrimaryKeyWithBLOBs(record);
	}




}
