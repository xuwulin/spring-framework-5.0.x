package com.xwl.ioc;

import com.xwl.ioc.bean.Person;
import com.xwl.ioc.config.ConfigScope;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author xwl
 * @date 2020-02-15 15:57
 * @description
 */
public class IOCTestConfigScope {

	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigScope.class); // 指定主配置类

	/**
	 * 测试bean实例的作用域
	 */
	@Test
	public void testScope() {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

		// 默认是单例的
		Person person = annotationConfigApplicationContext.getBean("person", Person.class);
		Person person2 = annotationConfigApplicationContext.getBean("person", Person.class);
		System.out.println(person == person2);
	}

	/**
	 * 测试@Conditional注解
	 * 注：VM Options参数设置：-Dos.name=linux，可以模拟linux环境
	 */
	@Test
	public void testConditional() {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

		ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
		// 动态获取当前操作系统的类型，Windows/Linux
		String property = environment.getProperty("os.name");
		System.out.println(property);
	}

	@Test
	public void testImport() {
		printBeans(annotationConfigApplicationContext);
	}

	@Test
	public void testFactoryBean() {
		// spring的FactoryBean获取的是调用getObject创建的对象
		Object schoole = annotationConfigApplicationContext.getBean("schooleFactoryBean");
		System.out.println("schooleFactoryBean.getObject()返回的类型为：" + schoole.getClass()); // class com.xwl.bean.School

		// 如果要获取SchooleFactoryBean本身，则用需要加 &
		Object schooleFactoryBean = annotationConfigApplicationContext.getBean("&schooleFactoryBean");
		System.out.println("schooleFactoryBean本身的类型为：" + schooleFactoryBean.getClass()); // class com.xwl.bean.SchooleFactoryBean
	}

	private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}
}
