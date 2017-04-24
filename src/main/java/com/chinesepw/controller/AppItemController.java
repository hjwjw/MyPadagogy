package com.chinesepw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinesepw.po.Appitem;
import com.chinesepw.service.IAppItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author HJW
 * @date 2017年4月23日
 * App的管理
 */

@Controller
public class AppItemController {
	
	@Autowired
	IAppItemService iAppItemService;
	
	@ResponseBody
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public PageInfo<Appitem> queryAll(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		List<Appitem> appitemList = new ArrayList<Appitem>();
		PageHelper.startPage(pageNum, pageSize);
		appitemList = iAppItemService.queryAll();
		return new PageInfo<Appitem>(appitemList);
	}
	
	
	public int deleteByPrimaryKey(Integer appId) {
		return iAppItemService.deleteByPrimaryKey(appId);
	}

	@ResponseBody
	public int insertSelective(Appitem record) {
		return iAppItemService.insertSelective(record);
	}

	@ResponseBody
	public Appitem selectByPrimaryKey(Integer appId) {
		return iAppItemService.selectByPrimaryKey(appId);
	}

	
	@ResponseBody
	public int updateByPrimaryKeyWithBLOBs(Appitem record) {
		return iAppItemService.updateByPrimaryKeyWithBLOBs(record);
	}

}
