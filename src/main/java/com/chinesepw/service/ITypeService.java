package com.chinesepw.service;

import java.util.List;

import com.chinesepw.po.Apptype;
import com.chinesepw.po.TypeLev;

/**
 * @author HJW
 * @date 2017年4月23日
 * 
 */
public interface ITypeService {
	
	public List<Apptype> query();
	
	public List<TypeLev> queryTypeLev(Integer typeId);
	
	public List<Apptype> selectByParentId(Integer parentId);
	
	public int deleteByPrimaryKey(Integer typeId);

	public int insert(Apptype record);

	public int insertSelective(Apptype record);

	public Apptype selectByPrimaryKey(Integer typeId);

	public int updateByPrimaryKeySelective(Apptype record);

	public int updateByPrimaryKey(Apptype record);
}
