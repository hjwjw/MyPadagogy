package com.chinesepw.mapper;

import com.chinesepw.po.Apptypelist;

public interface ApptypelistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Apptypelist record);

    int insertSelective(Apptypelist record);

    Apptypelist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apptypelist record);

    int updateByPrimaryKey(Apptypelist record);
}