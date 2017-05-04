package com.chinesepw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinesepw.po.Appitem;
import com.chinesepw.po.Keyword;
import com.chinesepw.po.Keywordlist;
import com.chinesepw.service.IKeywordListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author HJW
 * @date 2017年4月24日
 * 
 */
@Controller
@RequestMapping(value="/keyList")
public class KeywordListController {
	@Autowired
	IKeywordListService iKeywordListService;
	@Autowired
	KeywordController keywordController;
	@Autowired
	AppItemController appItemController;

	/**
	 * 通过appid查找app的标签分页输出
	 * @param appId
	 * @param pageNum
	 * @param pageSize
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="/selectKeyword",method=RequestMethod.GET)
	public PageInfo<Keyword> selectKeywordByAppId(Integer appId, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		List<Keywordlist> keywordlists = new ArrayList<Keywordlist>();
		List<Keyword> keywords = new ArrayList<Keyword>();
		PageHelper.startPage(pageNum, pageSize);
		keywordlists = iKeywordListService.selectKeywordByAppId(appId);
		
		for (Keywordlist keywordlist : keywordlists) {
			keywords.add(keywordController.selectByPrimaryKey(keywordlist.getKeyId()));
		}
		return new PageInfo<Keyword>(keywords);
	}

	/**
	 * 通过keyId 查找符合标签的app 并分页输出 
	 * @param keyId
	 * @param pageNum
	 * @param pageSize
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="/selectAppItem",method=RequestMethod.GET)
	public PageInfo<Appitem> selectAppItemByKeyId(Integer keyId, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		List<Keywordlist> keywordlists = new ArrayList<Keywordlist>();
		List<Appitem> appitemList = new ArrayList<Appitem>();
		PageHelper.startPage(pageNum, pageSize);
		keywordlists = iKeywordListService.selectAppItemByKeyId(keyId);
		
		for (Keywordlist keywordlist : keywordlists) {
			appitemList.add(appItemController.selectByPrimaryKey(keywordlist.getAppId()));
		}
		return new PageInfo<Appitem>(appitemList);
	}
	
	@RequestMapping(value="/del/{id}",method=RequestMethod.GET)
	public int deleteByPrimaryKey(@PathVariable("id") Integer keylistId) {
		return iKeywordListService.deleteByPrimaryKey(keylistId);
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public int insertSelective(Keywordlist record) {
		return iKeywordListService.insertSelective(record);
	}
	
	@RequestMapping(value="/select/{id}",method=RequestMethod.GET)
	public Keywordlist selectByPrimaryKey(@PathVariable("id") Integer keylistId) {
		return iKeywordListService.selectByPrimaryKey(keylistId);
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public int updateByPrimaryKeySelective(Keywordlist record) {
		return iKeywordListService.updateByPrimaryKeySelective(record);
	}
	
}
