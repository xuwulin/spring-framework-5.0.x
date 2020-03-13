package com.xwl.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xwl
 * @date 2020-02-24 20:47
 * @description
 * 默认加在IOC容器中的组件，容器启动就会调用无参构造器创建对象，再进行初始化赋值等操作
 */
@Component
public class Boss {
	private Car car;

	/**
	 * @Autowired 标注在有参构造器上，构造器要用的组件（构造器的参数）都是从IOC容器中获取
	 * @param car 方法使用的参数，自定义类型的值从IOC容器中获取，即这个参数car是从IOC容器中获取的
	 */
	@Autowired
	public Boss(Car car) {
		this.car = car;
		System.out.println("Boss 有参构造器");
	}

	public Car getCar() {
		return car;
	}

	/**
	 * @Autowired 标注在方法上，spring容器创建当前对象时，就会调用方法，完成赋值
	 * @param car 方法使用的参数，自定义类型的值从IOC容器中获取，即这个参数car是从IOC容器中获取的
	 */
//	@Autowired
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Boss{" +
				"car=" + car +
				'}';
	}
}
