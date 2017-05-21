package com.chinesepw.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinesepw.po.User;
import com.chinesepw.service.IUserService;
import com.chinesepw.util.MD5Util;

/**
 * @author HJW
 * @date 2017年5月12日
 * 
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Model model,String userName,String password,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		password = MD5Util.md5Encode(password);
		User u = iUserService.loginUser(userName, password);
		if (u == null) {
			resp.sendRedirect("/MyPadagogy/login.jsp");
			return "/login";
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("userId", u.getUserId());
			session.setAttribute("user", u.getUsername());
			session.setAttribute("lateTime", u.getLateTime());
			u.setLateTime(new Date());
			iUserService.updateByPrimaryKeySelective(u);
			model.addAttribute("user", u);
			return "/user";
		}
		
	}
	
	@RequestMapping(value="/loginOut")
	public void loginOut(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		HttpSession session =req.getSession();
		session.invalidate();
		resp.sendRedirect("/MyPadagogy");
	}
	
	@RequestMapping(value="/userReg",method = RequestMethod.POST)
	public void register(User user,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		user.setPassword(MD5Util.md5Encode(user.getPassword()));
		System.out.println(user);
		iUserService.insertSelective(user);
		resp.sendRedirect("/MyPadagogy/login.jsp");
	}
	
}
