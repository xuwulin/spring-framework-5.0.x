package com.xwl.ioc.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author xwl
 * @date 2020-02-12 21:59
 * @description
 */
public class Person {
	/**
	 * 使用@Value注解给属性赋值:
	 * 1、基本数值
	 * 2、可以是spel表达式：#{}
	 * 3、可以写${}，取出配置文件(.properties/.yml)中的值（在运行的环境变量中的值）
	 */
	@Value("史湘云")
	private String name;

	@Value("${person.nickname}")
	private String nickname;

	@Value("#{13-1}") // 使用@Value注解给属性赋值
	private Integer age;


	public Person() {
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", nickname='" + nickname + '\'' +
				", age=" + age +
				'}';
	}
}
