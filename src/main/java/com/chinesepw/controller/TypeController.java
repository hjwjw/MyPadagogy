package com.chinesepw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinesepw.po.Apptype;
import com.chinesepw.service.ITypeService;

/**
 * @author HJW
 * @date 2017年4月23日
 * 
 */
@Controller
@RequestMapping(value="type")
public class TypeController {
	
	@Autowired
	ITypeService iTypeService;
	 
	@ResponseBody
	@RequestMapping(value="/query",method = RequestMethod.GET)
	public List<Apptype> query() {
		return iTypeService.query();
	}
	
	
	@RequestMapping(value="/del/{id}",method=RequestMethod.GET)
	public int deleteByPrimaryKey(@PathVariable("id") Integer typeId) {
		return iTypeService.deleteByPrimaryKey(typeId);
	}

	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public int insertSelective(Apptype record) {
		return iTypeService.insertSelective(record);
	}

	@RequestMapping(value="/selectById",method=RequestMethod.GET)
	public Apptype selectByPrimaryKey(Integer typeId) {
		return iTypeService.selectByPrimaryKey(typeId);
	}

	@RequestMapping(value="updateById",method=RequestMethod.POST)
	public int updateByPrimaryKey(Apptype record) {
		return iTypeService.updateByPrimaryKey(record);
	}
}
