package com.chinesepw.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinesepw.service.IAppItemService;

/**
 * @author HJW
 * @date 2017年5月12日
 * 
 */
@Controller
@RequestMapping(value="admin")
public class ManagerController {
	
	@Autowired
	IAppItemService iappitemService;
	
	@RequestMapping(value="")
	public String Index(Model model,HttpServletRequest req, HttpServletResponse resp) {
		Integer PendingCount = iappitemService.queryPending().size();
		
		model.addAttribute("PendingCount", PendingCount);
		return "/WEB-INF/manager/index";
	}
	
	@RequestMapping(value="/loginOut")
	public void loginOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("../index.jsp");
		
	}
}
