package com.chinesepw.controller.restful;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinesepw.controller.AppItemController;
import com.chinesepw.po.Appitem;
import com.chinesepw.po.AppitemCustom;
import com.chinesepw.po.Apptype;
import com.chinesepw.po.Keywordlist;
import com.chinesepw.service.IAdminService;
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
@RequestMapping(value = "/appItemRest")
public class AppItemControllerRest {
	@Autowired
	AppItemController appItemController;
	@Autowired
	IAppItemService iAppItemService;
	@Autowired
	ITypeService iTypeService;
	@Autowired
	IApptypelistService iapptypelistService;
	@Autowired
	IKeywordService iKeywordService;
	@Autowired
	IKeywordListService ikeywordListService;
	@Autowired
	IApptypelistService iApptypelistService;
	@Autowired
	IUserService iUserService; 
	@Autowired
	IAdminService iadminService;
	
	private List<Apptype> apptypesAll = new ArrayList<Apptype>();

	@RequestMapping(value="/queryAll",method=RequestMethod.GET)
	public PageInfo<AppitemCustom> queryAll(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "6") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		PageHelper.startPage(pageNum, pageSize);
		List<AppitemCustom> appitemList = iAppItemService.queryAll();
		for (AppitemCustom ac : appitemList) {
			if (iUserService.selectByPrimaryKey(ac.getUserId()) == null) {
				ac.setUserName(iadminService.selectByPrimaryKey(ac.getUserId()).getName());
			}else{
				ac.setUserName(iUserService.selectByPrimaryKey(ac.getUserId()).getUsername());
			}
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
			if (iUserService.selectByPrimaryKey(ac.getUserId()) == null) {
				ac.setUserName(iadminService.selectByPrimaryKey(ac.getUserId()).getName());
			}else{
				ac.setUserName(iUserService.selectByPrimaryKey(ac.getUserId()).getUsername());
			}
			ac.setTypeName(appItemController.getTypeName(ac.getAppId()));
			ac.setStateStr("已通过");
		} 
		PageInfo<AppitemCustom> pageInfo = new PageInfo<AppitemCustom>(appitemList);
		return pageInfo;
	}
	
	@RequestMapping(value="/queryById/{id}",method=RequestMethod.GET)
	public AppitemCustom queryById(@PathVariable("id") Integer appId) {
		AppitemCustom appitemCustom =  iAppItemService.selectByPrimaryKey(appId);
		if (iUserService.selectByPrimaryKey(appitemCustom.getUserId()) == null) {
			appitemCustom.setUserName(iadminService.selectByPrimaryKey(appitemCustom.getUserId()).getName());
		}else{
			appitemCustom.setUserName(iUserService.selectByPrimaryKey(appitemCustom.getUserId()).getUsername());
		}
		appitemCustom.setTypeName(appItemController.getTypeName(appitemCustom.getAppId()));
		appitemCustom.setStateStr("已通过");
		return appitemCustom;
	}
	
	/**
	 * 递归查询一个分类下的所有子类
	 * @param parentId
	 */
	public void queryChildren(Integer parentId) {
		List<Apptype> apptypes = iTypeService.selectByParentId(parentId);
		
		if (apptypes!=null) {
			for (Apptype apptype : apptypes) {
				this.queryChildren(apptype.getTypeId());
				apptypesAll.add(apptype);
			}
		}
		
	}
	
	/**
	 * 按分类查找app
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value="/queryByType/{id}",method = RequestMethod.GET)
	public PageInfo<AppitemCustom> queryByType(@PathVariable("id") Integer typeId,@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		
/*		apptypesAll.clear();
		apptypesAll.add(iTypeService.selectByPrimaryKey(typeId));
		this.queryChildren(typeId);
		*/
		PageHelper.startPage(pageNum, pageSize);
		List<Integer> appIdList = iapptypelistService.getAppListByTypeId(typeId);
		PageInfo<Integer> pageInfoKey = new PageInfo<Integer>(appIdList);
		List<AppitemCustom> appitemList= new ArrayList<AppitemCustom>();
		for (Integer appId : appIdList) {
			AppitemCustom appitemCustom = iAppItemService.selectByPrimaryKey(appId);
			appitemList.add(appitemCustom);
		}
		PageInfo<AppitemCustom> pageInfo = new PageInfo<AppitemCustom>(appitemList);
		pageInfo.setStartRow(pageInfoKey.getStartRow());
		pageInfo.setEndRow(pageInfoKey.getEndRow());
		pageInfo.setTotal(pageInfoKey.getTotal());
		pageInfo.setPages(pageInfoKey.getPages());
		pageInfo.setNextPage(pageInfoKey.getNextPage());
		pageInfo.setLastPage(pageInfoKey.getLastPage());
		pageInfo.setIsLastPage(pageInfo.isIsLastPage());
		pageInfo.setHasNextPage(pageInfoKey.isHasNextPage());
		pageInfo.setNavigatepageNums(pageInfoKey.getNavigatepageNums());
		pageInfo.setPageNum(pageInfoKey.getPageNum());
		
		return pageInfo;
	}
	
	/**
	 * 根据标签来查找app
	 * @param keyId
	 * @return
	 */
	@RequestMapping(value="/queryByKey/{id}",method=RequestMethod.GET)
	public PageInfo<AppitemCustom> queryByKey(@PathVariable("id") Integer keyId,@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		PageHelper.startPage(pageNum, pageSize);
		List<Keywordlist> keywordlists = ikeywordListService.selectAppItemByKeyId(keyId);
		List<AppitemCustom> appitemList= new ArrayList<AppitemCustom>();
		for (Keywordlist keywordlist : keywordlists) {
			AppitemCustom appitemCustom = iAppItemService.selectByPrimaryKey(keywordlist.getAppId());
			appitemList.add(appitemCustom);
		}
		PageInfo<AppitemCustom> pageInfo = new PageInfo<AppitemCustom>(appitemList);
		return pageInfo;
	}
	
}
