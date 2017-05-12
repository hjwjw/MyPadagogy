package com.chinesepw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.lang.model.element.Element;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinesepw.po.AdminUser;
import com.chinesepw.service.IAdminService;
import com.chinesepw.util.Result;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author HJW 管理员操作 CURD （增删改查）
 */
@Controller
@RequestMapping("/manager")
public class AdminController {

	@Autowired
	private IAdminService iAdminService;

	/**
	 * 查询全部的管理员信息
	 * @param pageNum  页数
	 * @param pageSize 每页大小
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String toLogin() {
		return "/WEB-INF/manager/login";
	}
	
	@RequestMapping(value="loginAdmin",method = RequestMethod.POST)
	public String login(AdminUser adminUser,HttpServletRequest req,HttpServletResponse resp) {
		AdminUser ad = iAdminService.loginUser(adminUser);
		if (ad == null) {
			return "/WEB-INF/manager/login";
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("ad_id", ad.getId());
			session.setAttribute("admin", ad.getName());
			session.setAttribute("adminLateTime", ad.getLateTime());
			ad.setLateTime(new Date());
			iAdminService.updateByPrimaryKeySelective(ad);
			req.setAttribute("adminUser", ad);
			return "redirect:../admin";
		}
		
	}
	
	@RequestMapping(value = "/queryAll", method = RequestMethod.GET)
	public String query(Model model, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "4") int pageSize, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PageHelper.startPage(pageNum, pageSize);
		List<AdminUser> adminList  = iAdminService.queryAll();
		PageInfo<AdminUser> pageInfo = new PageInfo<AdminUser>(adminList);
		model.addAttribute("adminList",adminList);
		model.addAttribute("page",pageInfo);
		return "/WEB-INF/manager/managers"; 
		
	}

	/**
	 * 跳转到管理员新增页面（web-inf下的页面不能直接访问）
	 * @return
	 */
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd() {
		return "/WEB-INF/manager/add_Manager";
	}
	/**
	 * 新增，录入部分数据或全部数据
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public String insertSelective(AdminUser record, HttpServletRequest req, HttpServletResponse resp) {
		iAdminService.insertSelective(record);
		return "redirect: queryAll";
	}

	/**
	 * 删除管理员
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "del/{id}", method = { RequestMethod.GET })
	public String deleteByPrimaryKey(@PathVariable("id") Integer id, HttpServletRequest req, HttpServletResponse resp) {
			iAdminService.deleteByPrimaryKey(id);
			return "redirect: ../queryAll";

		
	}
	/**
	 * 多选操作 删除
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/selectDel", method = { RequestMethod.POST })
	public String SelectDeleteByPrimaryKey( HttpServletRequest req, HttpServletResponse resp) {
		 String[] adminInfos = req.getParameterValues("adminInfo"); 
		for (String ad_id : adminInfos) {
			if (ad_id != null) {
				 iAdminService.deleteByPrimaryKey(Integer.parseInt(ad_id));			
			}
		}
		return "redirect: queryAll";

		
	}

	/**
	 * 更新前获取数据
	 * @param model
	 * @param id
	 */
	@RequestMapping(value="up/{id}",method=RequestMethod.GET)
	public String selectByPrimaryKey(Model model,  @PathVariable("id") Integer id,HttpServletRequest req, HttpServletResponse resp) {
		AdminUser admin = iAdminService.selectByPrimaryKey(id);
		model.addAttribute("admin", admin);
		return "/WEB-INF/manager/add_Manager"; 
	}
	
	/**
	 * 更新管理员信息
	 * 
	 * @param record
	 * @return
	 */
	
	@RequestMapping(value="update/{id}",method=RequestMethod.POST)
	public String updateByPrimaryKey(AdminUser record, HttpServletRequest req, HttpServletResponse resp) {
		iAdminService.updateByPrimaryKey(record);
		return "redirect: ../queryAll";
		
		
		
	}
}
