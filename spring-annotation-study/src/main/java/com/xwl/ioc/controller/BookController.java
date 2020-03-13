package com.xwl.ioc.controller;

import com.xwl.ioc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author xwl
 * @date 2020-02-15 15:56
 * @description
 */
@Controller // 该类加上此注解，会自动被加载到IOC容器中，id为类名首字母小写，即bookController
public class BookController {

	/**
	 * 使用@Autowired注解自动装配组件BookService，
	 * 由于BookService这个类上使用了注解@Service，所以在IOC容器启动时会被加载到IOC容器中，使用注解@Autowired可以将其自动装配过来
	 */
	@Autowired
	private BookService bookService;
}
