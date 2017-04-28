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

import com.chinesepw.po.Keyword;
import com.chinesepw.service.IKeywordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author HJW
 * @date 2017年4月24日
 * 
 */
@Controller
@RequestMapping(value="/keyword")
public class KeywordController {
	
	@Autowired
	IKeywordService iKeywordService;
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public PageInfo<Keyword> queryAll(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		List<Keyword> keywordList = new ArrayList<Keyword>();
		PageHelper.startPage(pageNum, pageSize);
		keywordList = iKeywordService.queryAll();
		return new PageInfo<Keyword>(keywordList);
	}

	@RequestMapping(value="/del/{id}",method=RequestMethod.GET)
	public int deleteByPrimaryKey(@PathVariable("id") Integer keyId) {
		return iKeywordService.deleteByPrimaryKey(keyId);
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public int insertSelective(Keyword record) {
		return iKeywordService.insertSelective(record);
	}

	@RequestMapping(value="/select/{id}",method=RequestMethod.GET)
	public Keyword selectByPrimaryKey(@PathVariable("id") Integer keyId) {
		return iKeywordService.selectByPrimaryKey(keyId);
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public int updateByPrimaryKeySelective(Keyword record) {
		return iKeywordService.updateByPrimaryKeySelective(record);
	}
}
