package com.chinesepw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author HJW
 * @date 2017年5月12日
 * 
 */
public class UserInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		if (user != null) {
			return true;
		}
		String url = request.getRequestURI();
		
		//搜索String中的substring,默认从0位开始；
		if (url.indexOf("/appItem/typeList") >=0) {
			if(session.getAttribute("user") !=null || session.getAttribute("adminName") != null){
				return true;
			}
		}

		response.sendRedirect("/MyPadagogy/login.jsp");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
