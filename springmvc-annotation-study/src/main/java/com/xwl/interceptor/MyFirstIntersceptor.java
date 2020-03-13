package com.xwl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xwl
 * @date 2020-03-03 14:10
 * @description
 */
public class MyFirstIntersceptor implements HandlerInterceptor {

	/**
	 * 在目标方法运行之前执行
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler chosen handler to execute, for type and/or instance evaluation
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle...");
		return true;
	}

	/**
	 * 在目标方法执行之后执行
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler handler (or {@link }) that started asynchronous
	 * execution, for type and/or instance examination
	 * @param modelAndView the {@code ModelAndView} that the handler returned
	 * (can also be {@code null})
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle...");
	}

	/**
	 * 页面响应之后执行
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler handler (or {@link }) that started asynchronous
	 * execution, for type and/or instance examination
	 * @param ex exception thrown on handler execution, if any
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("afterCompletion...");
	}
}
