package com.xwl.ioc.bean;

/**
 * @author xwl
 * @date 2020-02-15 20:33
 * @description
 */
public class School {

	private Car car;

	public School() {
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "School{" +
				"car=" + car +
				'}';
	}
}
