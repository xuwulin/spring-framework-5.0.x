package com.xwl.ioc.service;

import com.xwl.ioc.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xwl
 * @date 2020-02-15 15:56
 * @description
 */
@Service // 该类加上此注解，会自动被加载到IOC容器中，id为类名首字母小写，即bookService
public class BookService {

	/**
	 * 使用@Autowired注解自动装配组件BookService，
	 * 由于BookService这个类上使用了注解@Service，所以在IOC容器启动时会被加载到IOC容器中，使用注解@Autowired可以将其自动装配过来
	 */
	// required默认为true，意味着自动装配默认一定要将属性赋好值，否则就会报错，
	// 可以将required设置为false，就表示不是必须要将属性赋好值
	@Autowired(required = true)
//	@Qualifier("bookDao2") // 使用@Qualifier()注解明确指定要装配的组件id，即这里指定要装配id为bookDao2的这个组件
//	@Resource(name = "bookDao2") // 功能和@Autowired注解一样，区别是@Resource默认按照组件的名称来装配，可以使用name属性来指定装配组件的名称
//	@Inject // 功能和@Autowired注解一样，支持@Primary注解，但是没有required这一属性
	private BookDao bookDao;

	public BookDao print() {
		System.out.println("在BookService中通过@Autowired注解自动注入BookDao：" + bookDao);
		return bookDao;
	}

	@Override
	public String toString() {
		return "BookService{" +
				"bookDao2=" + bookDao +
				'}';
	}
}
