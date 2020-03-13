package com.xwl.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xwl
 * @date 2020-02-16 16:57
 * @description
 */
public class Dog implements ApplicationContextAware { // 如果这个类想要使用IOC容器，则需要实现ApplicationContextAware接口

	// 定义IOC容器，在setApplicationContext方法中赋值
	private ApplicationContext applicationContext;

	public Dog() {
		System.out.println("Dog Constructor...");
	}

	@PostConstruct // 对象创建完成并赋值完后调用此方法
	public void init() {
		System.out.println("Dog @PostConstruct...");
	}

	@PreDestroy // 容器移除对象之前调用（回调通知）
	public void destory() {
		System.out.println("Dog @PreDestroy...");
	}

	/**
	 * ApplicationContextAware接口的实现方法
	 * @param applicationContext 这就是IOC容器，如果在其他方法中要使用IOC容器，可以定义一个变量并在此方法中赋值
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
