package com.chinesepw.service.Impl;

import java.util.List;

import javax.mail.Flags.Flag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinesepw.mapper.KeywordlistMapper;
import com.chinesepw.po.Keywordlist;
import com.chinesepw.service.IKeywordListService;

/**
 * @author HJW
 * @date 2017年4月24日
 * 
 */
@Service
public class KeywordListService implements IKeywordListService {

	@Autowired
	KeywordlistMapper keywordListMapper;
	
	@Override
	public List<Keywordlist> selectKeywordByAppId(Integer appId) {
		return keywordListMapper.selectKeywordByAppId(appId);
	}

	@Override
	public List<Keywordlist> selectAppItemByKeyId(Integer keyId) {
		return keywordListMapper.selectAppItemByKeyId(keyId);
	}

	@Override
	public int deleteByPrimaryKey(Integer keylistId) {
		return keywordListMapper.deleteByPrimaryKey(keylistId);
	}

	@Override
	public int insertSelective(Keywordlist record) {
		return keywordListMapper.insertSelective(record);
	}

	@Override
	public Keywordlist selectByPrimaryKey(Integer keylistId) {
		return keywordListMapper.selectByPrimaryKey(keylistId);
	}

	@Override
	public int updateByPrimaryKeySelective(Keywordlist record) {
		return keywordListMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByappId(Integer appId) {
		return keywordListMapper.deleteByappId(appId);
	}

	@Override
	public int deleteBykeyId(Integer keyId) {
		return keywordListMapper.deleteBykeyId(keyId);
	}

	@Override
	public boolean isHave(Integer keyId, Integer appId) {
		boolean falg = false;
		List<Keywordlist> keywordlists = keywordListMapper.isHave(keyId, appId);
		if (keywordlists.size() == 0) {
			falg = true;
		}
		return falg;
	}

}
