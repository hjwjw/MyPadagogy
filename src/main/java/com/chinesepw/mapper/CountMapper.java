package com.chinesepw.mapper;

import com.chinesepw.po.Count;

public interface CountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Count record);

    int insertSelective(Count record);

    Count selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Count record);

    int updateByPrimaryKey(Count record);
}