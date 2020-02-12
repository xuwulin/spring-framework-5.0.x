package com.xwl.bean;

/**
 * @author xwl
 * @date 2020-02-12 20:39
 * @description
 */
public class Person {
	private String id;
	private String name;

	public Person() {
	}

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String sayHello() {
		return "super man";
	}
}
