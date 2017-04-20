package com.chinesepw.mapper;

import com.chinesepw.po.Keywordlist;

public interface KeywordlistMapper {
    int deleteByPrimaryKey(Integer keylistId);

    int insert(Keywordlist record);

    int insertSelective(Keywordlist record);

    Keywordlist selectByPrimaryKey(Integer keylistId);

    int updateByPrimaryKeySelective(Keywordlist record);

    int updateByPrimaryKey(Keywordlist record);
}