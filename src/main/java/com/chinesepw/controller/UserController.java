package com.chinesepw.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinesepw.po.User;
import com.chinesepw.service.IUserService;

/**
 * @author HJW
 * @date 2017年5月12日
 * 
 */
@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Model model,String userName,String password,HttpServletRequest req,HttpServletResponse resp) {
		User u = iUserService.loginUser(userName, password);
		if (u == null) {
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
	
}
