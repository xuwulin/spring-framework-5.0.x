package com.xwl.ioc;

import com.xwl.ioc.config.ConfigLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xwl
 * @date 2020-02-15 15:57
 * @description
 */
public class IOCTestConfigLifeCycle {

	private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}

	@Test
	public void test() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigLifeCycle.class); // 指定主配置类
		System.out.println("容器创建完成");
		// 关闭容器
		annotationConfigApplicationContext.close();
	}
}
