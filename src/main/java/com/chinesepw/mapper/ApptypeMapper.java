package com.chinesepw.mapper;

import java.util.List;

import com.chinesepw.po.Apptype;
import com.chinesepw.po.TypeLev;

public interface ApptypeMapper {
	
	List<Apptype> query();
	
	List<TypeLev> queryTypeLev(Integer typeId);
	
	List<Apptype> selectByParentId(Integer parentId);
	
    int deleteByPrimaryKey(Integer typeId);

    int insert(Apptype record);

    int insertSelective(Apptype record);

    Apptype selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(Apptype record);

    int updateByPrimaryKey(Apptype record);
}