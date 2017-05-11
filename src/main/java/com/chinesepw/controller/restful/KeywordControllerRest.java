package com.chinesepw.controller.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinesepw.po.Keyword;
import com.chinesepw.service.IKeywordService;

/**
 * @author HJW
 * @date 2017年5月11日
 * 
 */
@RestController
@RequestMapping(value="keywordRest")
public class KeywordControllerRest {
	
	@Autowired
	IKeywordService iKeywordService;
	
	@RequestMapping(value="queryAll",method=RequestMethod.GET)
	public List<Keyword> queryAll() {
		return iKeywordService.queryAll();
	}
}
