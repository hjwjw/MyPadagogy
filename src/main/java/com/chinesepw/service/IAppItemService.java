package com.chinesepw.service;

import java.util.List;

import com.chinesepw.po.Appitem;
import com.chinesepw.po.AppitemCustom;

/**
 * @author HJW
 * @date 2017年4月23日
 * 
 */
public interface IAppItemService {
	public List<AppitemCustom> queryAll();
	
	public int deleteByPrimaryKey(Integer appId);

    public int insertSelective(Appitem record);

    Appitem selectByPrimaryKey(Integer appId);

    public int updateByPrimaryKeyWithBLOBs(Appitem record);

}
