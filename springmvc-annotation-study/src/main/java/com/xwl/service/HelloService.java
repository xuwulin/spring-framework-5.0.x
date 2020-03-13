package com.xwl.service;

import org.springframework.stereotype.Service;

/**
 * @author xwl
 * @date 2020-03-03 11:54
 * @description
 */
@Service
public class HelloService {

	public String sayHello(String name) {
		return "hello " + name;
	}
}
