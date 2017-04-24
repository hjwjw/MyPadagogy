package com.chinesepw.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinesepw.mapper.ApptypeMapper;
import com.chinesepw.po.Apptype;
import com.chinesepw.service.ITypeService;

/**
 * @author HJW
 * @date 2017年4月23日
 * 
 */
@Service
public class TypeService implements ITypeService {
	
	@Autowired
	ApptypeMapper appTypeMapper;
	
	@Override	
	public List<Apptype> query(){
		return appTypeMapper.query();
	}
	
	@Override
	public int deleteByPrimaryKey(Integer typeId) {
		return appTypeMapper.deleteByPrimaryKey(typeId);
	}

	@Override
	public int insert(Apptype record) {
		return appTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(Apptype record) {
		return appTypeMapper.insertSelective(record);
	}

	@Override
	public Apptype selectByPrimaryKey(Integer typeId) {
		return appTypeMapper.selectByPrimaryKey(typeId);
	}

	@Override
	public int updateByPrimaryKeySelective(Apptype record) {
		return appTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Apptype record) {
		return appTypeMapper.updateByPrimaryKey(record);
	}

}
