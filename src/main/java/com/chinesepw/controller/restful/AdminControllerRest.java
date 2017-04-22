package com.chinesepw.controller.restful;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinesepw.po.Admin;
import com.chinesepw.service.IAdminService;
import com.chinesepw.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author HJW 管理员操作 CURD （增删改查）
 * restful 风格
 */
@RestController
@RequestMapping("/manager")
public class AdminControllerRest {

	@Autowired
	private IAdminService iAdminService;

	/**
	 * 查询全部的管理员信息
	 * @param pageNum  页数
	 * @param pageSize 每页大小
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public PageInfo<Admin> query(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		List<Admin> adminList = new ArrayList<Admin>();
		PageHelper.startPage(pageNum, pageSize);
		adminList = iAdminService.queryAll();
		PageInfo<Admin> pageInfo = new PageInfo<Admin>(adminList);
		return pageInfo;
	}

	/**
	 * 新增，录入全部数据
	 * 
	 * @param record
	 * @return
	 */
	/*@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public Result<Integer> insert(Admin record, HttpServletRequest req, HttpServletResponse resp) {
		Integer i = 0;
		if (record != null) {
			i = iAdminService.insert(record);
			return new Result<Integer>("success", 0, i);
		}
		return new Result<Integer>("erro", -1, null);
	}*/

	/**
	 * 新增，录入部分数据或全部数据
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.POST })
	public Result<Integer> insertSelective(Admin record, HttpServletRequest req, HttpServletResponse resp) {
		Integer i = 0;
		if (record != null) {
			i = iAdminService.insertSelective(record);
			return new Result<Integer>("success", 0, i);
		}
		return new Result<Integer>("erro", -1, null);
	}

	/**
	 * 删除管理员
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id, HttpServletRequest req, HttpServletResponse resp) {
		Integer i = 0;
		if (id != null) {
			i = iAdminService.deleteByPrimaryKey(id);
			return new Result<Integer>("success", 0, i);
		}
		return new Result<Integer>("erro", -1, null);
		
	}

	/**
	 * 更新管理员信息
	 * 
	 * @param record
	 * @return
	 */
	/*@RequestMapping(value="/updateSelective",method=RequestMethod.POST)
	public Result<Integer> updateByPrimaryKeySelective(Admin record, HttpServletRequest req, HttpServletResponse resp) {
		Integer i = 0;
		if (record != null) {
			i = iAdminService.updateByPrimaryKeySelective(record);
			return new Result<Integer>("success", 0, i);
		}
		return new Result<Integer>("erro", -1, null);
		
	}*/
	
	/**
	 * 更新管理员信息
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Result<Integer> updateByPrimaryKey(Admin record, HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(record);
		Integer i = 0;
		if (record != null) {
			i = iAdminService.updateByPrimaryKey(record);
			return new Result<Integer>("success", 0, i);
		}
		return new Result<Integer>("erro", -1, null);
		
	}
}
