package com.chinesepw.service;

import java.util.List;

import com.chinesepw.po.Keyword;

/**
 * @author HJW
 * @date 2017年4月24日
 * 
 */
public interface IKeywordService {
	public List<Keyword> queryAll();
	
    public int deleteByPrimaryKey(Integer keyId);

    public int insertSelective(Keyword record);

    public Keyword selectByPrimaryKey(Integer keyId);

    public int updateByPrimaryKeySelective(Keyword record);

}
