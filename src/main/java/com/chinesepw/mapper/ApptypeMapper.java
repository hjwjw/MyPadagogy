package com.chinesepw.mapper;

import java.util.List;

import com.chinesepw.po.Apptype;

public interface ApptypeMapper {
	
	List<Apptype> query();
	
    int deleteByPrimaryKey(Integer typeId);

    int insert(Apptype record);

    int insertSelective(Apptype record);

    Apptype selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(Apptype record);

    int updateByPrimaryKey(Apptype record);
}