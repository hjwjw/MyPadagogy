package com.chinesepw.mapper;

import com.chinesepw.po.Apptype;

public interface ApptypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Apptype record);

    int insertSelective(Apptype record);

    Apptype selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(Apptype record);

    int updateByPrimaryKey(Apptype record);
}