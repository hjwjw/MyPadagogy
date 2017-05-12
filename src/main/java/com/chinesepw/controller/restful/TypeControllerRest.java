package com.chinesepw.controller.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/queryAll",method=RequestMethod.GET)
	public List<Apptype> queryAll() {
		List<Apptype> appTypes = iTypeService.query();
		return appTypes;
	}
	
	@RequestMapping(value="/queryParentId",method=RequestMethod.GET)
	public List<Apptype> queryParentId(Integer parentId) {
		return iTypeService.selectByParentId(parentId);
	}
}
