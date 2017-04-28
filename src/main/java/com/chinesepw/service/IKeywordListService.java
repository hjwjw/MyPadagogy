package com.chinesepw.service;

import java.util.List;

import com.chinesepw.po.Keywordlist;

/**
 * @author HJW
 * @date 2017年4月24日
 * 
 */
public interface IKeywordListService {

	public List<Keywordlist> selectKeywordByAppId(Integer appId);
	
	public List<Keywordlist> selectAppItemByKeyId(Integer keyId);
	
    public int deleteByPrimaryKey(Integer keylistId);

    public int insertSelective(Keywordlist record);

    public Keywordlist selectByPrimaryKey(Integer keylistId);

    public int updateByPrimaryKeySelective(Keywordlist record);

}
