package com.xwl.ioc.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xwl
 * @date 2020-02-15 18:50
 * @description 判断系统是否为windows
 */
public class WindowsCondition implements Condition {
	/**
	 *
	 * @param context 判断条件能使用的上下文环境
	 * @param metadata 当前标注了@Conditional注解的注释信息
	 *
	 * @return
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 获取到IOC使用的beanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		// 获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		// 获取当前环境信息
		Environment environment = context.getEnvironment();
		// 获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		// 判断容器中bean注册的情况，也可以给容器中注册bean
		boolean person = registry.containsBeanDefinition("person");

		// 获取当前操作系统类型（名称）
		String property = environment.getProperty("os.name");
		if (property.contains("Windows")) {
			return true;
		}
		return false;
	}
}
