package com.chinesepw.mapper;

import java.util.List;

import com.chinesepw.po.Keyword;

public interface KeywordMapper {
	List<Keyword> queryAll();
	
    int deleteByPrimaryKey(Integer keyId);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    Keyword selectByPrimaryKey(Integer keyId);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);
}