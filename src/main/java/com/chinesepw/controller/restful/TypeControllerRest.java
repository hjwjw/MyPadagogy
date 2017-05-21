package com.chinesepw.controller.restful;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.chinesepw.po.Apptype;
import com.chinesepw.service.ITypeService;

/**
 * @author HJW
 * @date 2017年5月11日
 * 
 */
@RestController
@RequestMapping(value="/appTypeRest")
public class TypeControllerRest {
	
	@Autowired
	ITypeService iTypeService;
	
	private List<Apptype> apptypesAll = new ArrayList<Apptype>();
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
	
	@RequestMapping(value="/queryAll",method=RequestMethod.GET)
	public List<Apptype> queryAll() {
		List<Apptype> appTypes = iTypeService.query();
		return appTypes;
	}
	
	@RequestMapping(value="/queryParentId",method=RequestMethod.GET)
	public List<Apptype> queryParentId( Integer parentId) {
		return iTypeService.selectByParentId(parentId);
	}
}
