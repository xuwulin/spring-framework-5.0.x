package com.xwl.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author xwl
 * @date 2020-02-24 21:34
 * @description
 */
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

	private ApplicationContext applicationContext;

	@Override
	public void setBeanName(String name) {
		System.out.println("当前Bean的名字：" + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("传入的IOC：" + applicationContext);
	}

	/**
	 *
	 * @param resolver 值解析器，可以解析#{},${}等表达式
	 *       ${}读取配置文件中的值，#{}是spring的表达式
	 */
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String resolveStringValue = resolver.resolveStringValue("你好${os.name}，我是#{20 * 18}");
		System.out.println("解析的字符串是：" + resolveStringValue);
	}
}
