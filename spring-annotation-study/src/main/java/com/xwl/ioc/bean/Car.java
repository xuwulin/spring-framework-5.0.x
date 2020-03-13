package com.xwl.ioc.bean;

import org.springframework.stereotype.Component;

/**
 * @author xwl
 * @date 2020-02-24 20:47
 * @description
 */
@Component
public class Car {
	public Car() {
		System.out.println("Car constructor...");
	}

	public void init() {
		System.out.println("Car init...");
	}

	public void destory() {
		System.out.println("Car destory...");
	}
}
