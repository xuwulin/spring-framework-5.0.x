package com.xwl.config;

import com.xwl.interceptor.MyFirstIntersceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @author xwl
 * @date 2020-03-03 11:41
 * @description
 * web容器的配置类（相当于以前xml版的spring-mvc的配置文件：dispatcherServlet-servlet.xml），作为子容器
 * 父子容器效果：子容器 只 扫描所有的控制器以及和网站功能有关的逻辑组件
 */
// 子容器，扫描com.xwl下所有的类，只需要扫描标注 @Controller 注解的类，其余的交给父容器扫描
// 注意使用includeFilters的时候，一定要使用 useDefaultFilters = false 禁用默认的过滤规则，这样includeFilters才能生效
@ComponentScan(value = "com.xwl", includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@EnableWebMvc // 开启SpringMVC定制配置功能；相当于配置文件中的<mvc:annotation-driven/>；
public class AppConfig implements WebMvcConfigurer { // WebMvcConfigurerAdapter已过时，直接实现WebMvcConfigurer替换

	// 定制方法

	/**
	 * 配置视图解析器
	 * @param registry
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 默认所有的jsp页面都从 /WEB-INF/ 找 xxx.jsp
//		registry.jsp();
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	/**
	 * 处理静态资源
	 * 因为springmvc拦截了所有的请求，包括静态资源，所有需要将静态资源交给tomcat处理
	 * 相当于配置文件中的<mvc:default-servlet-handler/>
	 * @param configurer
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 添加拦截器
	 * 相当于配置文件中的<mvc:interceptors>
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyFirstIntersceptor())
				.addPathPatterns("/**"); // 拦截哪些请求，/**：表示拦截任意路径
	}
}
