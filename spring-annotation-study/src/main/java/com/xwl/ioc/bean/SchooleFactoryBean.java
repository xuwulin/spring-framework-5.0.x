package com.xwl.ioc.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xwl
 * @date 2020-02-15 20:32
 * @description 创建一个spring定义的FactoryBean
 */
public class SchooleFactoryBean implements FactoryBean<School> {
	/**
	 * 返回一个School对象，这个对象户添加到IOC容器中
	 * @return
	 * @throws Exception
	 */
	@Override
	public School getObject() throws Exception {
		System.out.println("SchooleFactoryBean==>getObject...");
		return new School();
	}

	/**
	 * 返回一个类型
	 * @return
	 */
	@Override
	public Class<?> getObjectType() {
		return School.class;
	}

	/**
	 * 返回是单例还是多例
	 * true：表示单实例，在IOC中保存一份
	 * false：表示多实例，每次获取都会创建一个
	 * @return
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}
}
