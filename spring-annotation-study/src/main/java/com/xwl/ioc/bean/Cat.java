package com.xwl.ioc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author xwl
 * @date 2020-02-16 16:42
 * @description
 */
public class Cat implements InitializingBean, DisposableBean {

	public Cat() {
		System.out.println("Cat Constructor...");
	}

	/**
	 * 初始化方法
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Cat afterPropertiesSet（init）...");
	}

	/**
	 * 销毁方法，在IOC容器关闭的时候调用
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("Cat destroy...");
	}
}
