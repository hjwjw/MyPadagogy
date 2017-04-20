package com.chinesepw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinesepw.po.Admin;
import com.chinesepw.service.IAdminService;

@RestController
@RequestMapping("/manager")
public class AdminController {
	
	@Autowired
	private IAdminService iAdminService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public String test() {
		return "成功";
	}
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public int insert(Admin record) {
		return iAdminService.insert(record);
	}
	
	@RequestMapping(value="/addSelective",method={RequestMethod.POST})
	public int insertSelective(Admin record) {
		return iAdminService.insertSelective(record);
	}
	
	@RequestMapping(value="/del",method={RequestMethod.POST})
	public int deleteByPrimaryKey(Integer id) {
		return iAdminService.deleteByPrimaryKey(id);
	}
}
