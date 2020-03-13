package com.xwl.ioc;

import com.xwl.ioc.bean.Boss;
import com.xwl.ioc.bean.Car;
import com.xwl.ioc.bean.School;
import com.xwl.ioc.config.ConfigAutowired;
import com.xwl.ioc.dao.BookDao;
import com.xwl.ioc.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xwl
 * @date 2020-02-16 18:36
 * @description
 */
public class IOCTestConfigAutowired {

	private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}

	@Test
	public void testAutowired() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigAutowired.class); // 指定主配置类
		System.out.println("容器创建完成");

		// 在BookService中通过@Autowired自动注入组件BookDao，获取BookDao组件
		BookService bookService = applicationContext.getBean(BookService.class);
		BookDao print = bookService.print();

		// 从IOC容器中获取BookDao
		BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");
		System.out.println(bookDao);

		System.out.println(print == bookDao); // true 说明以上两者获取的都是同一个BookDao对象

		Boss boss = applicationContext.getBean(Boss.class);
		System.out.println(boss);

		Car car = applicationContext.getBean(Car.class);
		System.out.println(car);

		School school = applicationContext.getBean(School.class);
		System.out.println(school);

		// 关闭容器
		applicationContext.close();
	}

	@Test
	public void test() {
		String a = "Programming";
		String b = new String("Programming");
		String c = "Program" + "ming";
		System.out.println(a == b); // false
		System.out.println(a == c); // true
		System.out.println(a.equals(b)); // true
		System.out.println(a.equals(c)); // true
		System.out.println(a.intern() == b.intern()); // true

		String hello = reverse("hello");
		System.out.println(hello);
	}

	/**
	 * 递归实现字符串反转
	 * @param originStr
	 * @return
	 */
	public static String reverse(String originStr) {
		if (originStr == null || originStr.length() <= 1) {
			return originStr;
		}
		return reverse(originStr.substring(1)) + originStr.charAt(0);
	}

}
