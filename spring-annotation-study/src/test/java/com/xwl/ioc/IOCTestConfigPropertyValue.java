package com.xwl.ioc;

import com.xwl.ioc.bean.Person;
import com.xwl.ioc.config.ConfigPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author xwl
 * @date 2020-02-16 18:36
 * @description
 */
public class IOCTestConfigPropertyValue {

	private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}

	@Test
	public void testBeanPropertyValue() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigPropertyValue.class); // 指定主配置类
		System.out.println("容器创建完成");
		printBeans(applicationContext);

		Person person = applicationContext.getBean("person", Person.class);
		System.out.println(person);

		// 外部配置文件（person.properties）中的k/v值也可以使用以下这种方式读取
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("person.nickname"); // 配置文件中的key
		System.out.println(property);

		// 关闭容器
		applicationContext.close();
	}
}
