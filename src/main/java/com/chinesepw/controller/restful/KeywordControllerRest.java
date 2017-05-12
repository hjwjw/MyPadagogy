package com.chinesepw.controller.restful;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinesepw.po.Keyword;
import com.chinesepw.service.IKeywordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author HJW
 * @date 2017年5月11日
 * 
 */
@RestController
@RequestMapping(value="/keywordRest")
public class KeywordControllerRest {
	
	@Autowired
	IKeywordService iKeywordService;
	
	@RequestMapping(value="/queryAll",method=RequestMethod.GET)
	public PageInfo<Keyword> queryAll(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "6") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		PageHelper.startPage(pageNum, pageSize);
		List<Keyword> keywords = iKeywordService.queryAll();
		PageInfo<Keyword> pageInfo = new PageInfo<Keyword>(keywords);
		return pageInfo;
	}
	
	@RequestMapping(value="/queryById/{id}",method=RequestMethod.GET)
	public Keyword queryById(@PathVariable("id") Integer keyId) {
		return iKeywordService.selectByPrimaryKey(keyId);
	}
}
