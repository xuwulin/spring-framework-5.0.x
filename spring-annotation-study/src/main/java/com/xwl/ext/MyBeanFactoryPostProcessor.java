package com.xwl.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author xwl
 * @date 2020-02-27 22:18
 * @description BeanFactoryPostProcessor：beanFactory的后置处理器；
 *
 * 在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；
 * 此时所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	/**
	 * 该方法在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；
	 * 此时所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory");
		int count = beanFactory.getBeanDefinitionCount();
		String[] names = beanFactory.getBeanDefinitionNames();
		System.out.println("当前BeanFactory中有" + count + "个Bean");
		System.out.println(Arrays.asList(names));
	}
}
