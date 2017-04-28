package com.chinesepw.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinesepw.mapper.KeywordMapper;
import com.chinesepw.po.Keyword;
import com.chinesepw.service.IKeywordService;

/**
 * @author HJW
 * @date 2017年4月24日
 * 
 */
@Service
public class KeywordService implements IKeywordService {

	@Autowired
	KeywordMapper keywordMapper;
	
	@Override
	public List<Keyword> queryAll() {
		return keywordMapper.queryAll();
	}

	@Override
	public int deleteByPrimaryKey(Integer keyId) {
		return keywordMapper.deleteByPrimaryKey(keyId);
	}

	@Override
	public int insertSelective(Keyword record) {
		return keywordMapper.insertSelective(record);
	}

	@Override
	public Keyword selectByPrimaryKey(Integer keyId) {
		return keywordMapper.selectByPrimaryKey(keyId);
	}

	@Override
	public int updateByPrimaryKeySelective(Keyword record) {
		return keywordMapper.updateByPrimaryKeySelective(record);
	}

}
