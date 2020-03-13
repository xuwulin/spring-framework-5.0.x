package com.xwl.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author xwl
 * @date 2020-02-16 17:04
 * @description 后置处理器：初始化前后进行处理工作
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {
		System.out.println("MyBeanPostProcessor Constructor...");
	}

	/**
	 *
	 * @param bean 刚创建的实例
	 * @param beanName 实例的名称
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor...postProcessBeforeInitialization..." + bean + "==>" + beanName);
		return bean;
	}

	/**
	 *
	 * @param bean 刚创建的实例
	 * @param beanName 实例的名称
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor...postProcessAfterInitialization..." + bean + "==>" + beanName);
		return bean;
	}
}
