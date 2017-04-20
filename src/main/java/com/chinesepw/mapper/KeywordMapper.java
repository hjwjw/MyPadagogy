package com.chinesepw.mapper;

import com.chinesepw.po.Keyword;

public interface KeywordMapper {
    int deleteByPrimaryKey(Integer keyId);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    Keyword selectByPrimaryKey(Integer keyId);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKeyWithBLOBs(Keyword record);

    int updateByPrimaryKey(Keyword record);
}