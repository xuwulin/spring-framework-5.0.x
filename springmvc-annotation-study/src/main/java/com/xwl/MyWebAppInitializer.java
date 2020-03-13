package com.xwl;

import com.xwl.config.AppConfig;
import com.xwl.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author xwl
 * @date 2020-03-03 11:27
 * @description
 * 会在web容器启动时创建对象：调用方法来初始化容器以及前端控制器
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * 获取根容器的配置类（相当于以前xml版的spring的配置文件：applicationContext.xml），作为父容器
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	/**
	 * 获取web容器的配置类（相当于以前xml版的spring-mvc的配置文件：dispatcherServlet-servlet.xml），作为子容器
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}

	/**
	 * 获取前端控制器DispatcherServlet的映射信息
	 * /：表示拦截所有请求，包括静态资源：xxx.png,xxx.js，但是不包括：xxx.jsp
	 * /*：也表示拦截所有请求，包括静态资源：xxx.png,xxx.js，也包括：xxx.jsp
	 * jsp页面是有tomcat的jsp引擎解析的
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {
		// /：表示拦截所有请求，包括静态资源：xxx.png,xxx.js，但是不包括：xxx.jsp
		// /*：也表示拦截所有请求，包括静态资源：xxx.png,xxx.js，也包括：xxx.jsp
		return new String[]{"/"};
	}
}
