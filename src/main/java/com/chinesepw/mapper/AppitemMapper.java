package com.chinesepw.mapper;

import com.chinesepw.po.Appitem;

public interface AppitemMapper {
    int deleteByPrimaryKey(Integer appId);

    int insert(Appitem record);

    int insertSelective(Appitem record);

    Appitem selectByPrimaryKey(Integer appId);

    int updateByPrimaryKeySelective(Appitem record);

    int updateByPrimaryKeyWithBLOBs(Appitem record);

    int updateByPrimaryKey(Appitem record);
}