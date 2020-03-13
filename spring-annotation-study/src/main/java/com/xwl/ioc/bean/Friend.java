package com.xwl.ioc.bean;

/**
 * @author xwl
 * @date 2020-02-15 20:08
 * @description
 */
public class Friend {
	public Friend() {
		System.out.println("Friend Constructor...");
	}

	/**
	 * 初始化方法
	 */
	public void init() {
		System.out.println("Friend init...");
	}

	/**
	 * 销毁方法
	 */
	public void destory() {
		System.out.println("Friend destory...");
	}
}
