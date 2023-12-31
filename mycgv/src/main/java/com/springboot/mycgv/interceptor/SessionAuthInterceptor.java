package com.springboot.mycgv.interceptor;

import com.springboot.mycgv.dto.SessionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class SessionAuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		HttpSession session = request.getSession();
		
		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");

		if(sessionVo == null) {
			response.sendRedirect("/login");
			return false;
		}
		
		return true;
	}
}
