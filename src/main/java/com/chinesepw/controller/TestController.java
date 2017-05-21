package com.chinesepw.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinesepw.po.AdminUser;

/**
 * @author HJW
 * @date 2017年4月28日
 * 
 */

@Controller
@RequestMapping(value="/test")
public class TestController {

	@RequestMapping(value="", method = RequestMethod.GET)
	public void testreq(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException  {
		System.out.println("Testreq success!"); 
		req.getRequestDispatcher("/WEB-INF/manager/typeList.jsp").forward(req, resp);
	}
	
	@RequestMapping(value="test2", method = RequestMethod.GET)
	public String test(Model model,HttpServletRequest req,HttpServletResponse resp)  {
		System.out.println("Test2 success!");
		AdminUser a1 = new AdminUser();
		AdminUser a2 = new AdminUser();
		a1.setName("hjwww");
		a1.setPwd("123");
		a2.setName("www");
		a2.setPwd("rew");
		ArrayList<AdminUser> a = new ArrayList<AdminUser>();
		a.add(a1);
		a.add(a2);
		model.addAttribute("adminList", a);
		return "/WEB-INF/manager/managers";
				
	}
}
