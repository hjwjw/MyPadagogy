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
	
	public List<AppitemCustom> queryAllOrderByCount();
	
	public List<AppitemCustom> queryPending();
	
	public int deleteByPrimaryKey(Integer appId);

	/**
	 * 新增一条记录，并返回新记录的ID
	 * @param record
	 * @return
	 */
    public int insertSelective(Appitem record);

    AppitemCustom selectByPrimaryKey(Integer appId);

    public int updateByPrimaryKeyWithBLOBs(Appitem record);

}
