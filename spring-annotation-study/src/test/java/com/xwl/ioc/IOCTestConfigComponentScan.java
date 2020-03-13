package com.xwl.ioc;

import com.xwl.ioc.bean.Person;
import com.xwl.ioc.config.ConfigComponentScan;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xwl
 * @date 2020-02-15 15:57
 * @description
 */
public class IOCTestConfigComponentScan {

	/**
	 * 测试使用配置文件beans.xml，并读取配置文件中注册的bean
	 */
	@Test
	public void testClassPathXmlApplicationContext() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext =
				new ClassPathXmlApplicationContext("beans.xml"); // 参数为配置文件
		Person person = (Person) classPathXmlApplicationContext.getBean("person");
		System.out.println(person);
	}

	/**
	 * 测试使用注解的方式（编写配置类）
	 */
	@Test
	public void testAnnotationConfigApplicationContext() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(ConfigComponentScan.class); // 参数为配置类
		Person person1 = annotationConfigApplicationContext.getBean(Person.class);
		System.out.println(person1);
	}

	/**
	 * 测试使用配置类获取IOC中注册的type类型的bean的名字（id）
	 */
	@Test
	public void testBeanNamesForType() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(ConfigComponentScan.class); // 参数为配置类
		// 获取IOC中注册的type类型的bean的名字
		String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
	}

	/**
	 * 测试IOC容器中注册的所有的bean的名字
	 */
	@Test
	public void testBeanDefinitionNames() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigComponentScan.class); // 指定主配置类
		// 获取IOC容器中注册的所有的bean的名字
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
			// 打印结果：
//			org.springframework.context.annotation.internalConfigurationAnnotationProcessor
//			org.springframework.context.annotation.internalAutowiredAnnotationProcessor
//			org.springframework.context.annotation.internalRequiredAnnotationProcessor
//			org.springframework.context.annotation.internalCommonAnnotationProcessor
//			org.springframework.context.event.internalEventListenerProcessor
//			org.springframework.context.event.internalEventListenerFactory
			// 以上为IOC容器中自己本身要装配的组件
			// 以下为我们自己定义的需要被IOC加载的组件
//			mainConfig
//			bookController
//			bookDao
//			bookService
//			person1
		}
	}

}
