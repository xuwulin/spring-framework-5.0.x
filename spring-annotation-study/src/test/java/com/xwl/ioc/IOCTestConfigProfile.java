package com.xwl.ioc;

import com.xwl.ioc.config.ConifgProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xwl
 * @date 2020-02-16 18:36
 * @description
 */
public class IOCTestConfigProfile {

	private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}

	/**
	 * 切换环境的方式一：使用命令行动态参数：-Dspring.profiles.active=test  标识切换到test环境
	 */
	@Test
	public void testProfile() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConifgProfile.class); // 指定主配置类
		System.out.println("容器创建完成");

		printBeans(applicationContext);

		// 关闭容器
		applicationContext.close();
	}

	/**
	 * 切换环境的方式二：使用代码的方式激活某种环境
	 */
	@Test
	public void testProfile2() {
		// 1、创建一个applicationContext
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		System.out.println("容器创建完成");
		// 2、设置需要激活的环境，可以设置多个
		applicationContext.getEnvironment().setActiveProfiles("test", "dev");
		// 3、注册配置类
		applicationContext.register(ConifgProfile.class);
		// 4、启动刷新容器
		applicationContext.refresh();

		printBeans(applicationContext);

		// 关闭容器
		applicationContext.close();
	}
}
