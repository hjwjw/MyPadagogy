package com.chinesepw.controller.restful;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinesepw.controller.AppItemController;
import com.chinesepw.po.AppitemCustom;
import com.chinesepw.service.IAppItemService;
import com.chinesepw.service.IApptypelistService;
import com.chinesepw.service.IKeywordListService;
import com.chinesepw.service.IKeywordService;
import com.chinesepw.service.ITypeService;
import com.chinesepw.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author HJW
 * @date 2017年5月10日
 * 
 */
@RestController
@RequestMapping(value = "appItemRest")
public class AppItemControllerRest {
	@Autowired
	AppItemController appItemController;
	@Autowired
	IAppItemService iAppItemService;
	@Autowired
	ITypeService iTypeService;
	@Autowired
	IKeywordService iKeywordService;
	@Autowired
	IKeywordListService ikeywordListService;
	@Autowired
	IApptypelistService iApptypelistService;
	@Autowired
	IUserService iUserService; 

	@RequestMapping(value="/queryAll",method=RequestMethod.GET)
	public PageInfo<AppitemCustom> queryAll(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		PageHelper.startPage(pageNum, pageSize);
		List<AppitemCustom> appitemList = iAppItemService.queryAll();
		for (AppitemCustom ac : appitemList) {
			ac.setUserName(iUserService.selectByPrimaryKey(ac.getUserId()).getUsername());
			ac.setTypeName(appItemController.getTypeName(ac.getAppId()));
			ac.setStateStr("已通过");
		} 
		PageInfo<AppitemCustom> pageInfo = new PageInfo<AppitemCustom>(appitemList);
		return pageInfo;
	}
	
	@RequestMapping(value="/queryAllHot",method=RequestMethod.GET)
	public PageInfo<AppitemCustom> queryAllHot(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "9") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		PageHelper.startPage(pageNum, pageSize);
		List<AppitemCustom> appitemList = iAppItemService.queryAll();
		for (AppitemCustom ac : appitemList) {
			ac.setUserName(iUserService.selectByPrimaryKey(ac.getUserId()).getUsername());
			ac.setTypeName(appItemController.getTypeName(ac.getAppId()));
			ac.setStateStr("已通过");
		} 
		PageInfo<AppitemCustom> pageInfo = new PageInfo<AppitemCustom>(appitemList);
		return pageInfo;
	}
	
}
