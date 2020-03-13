package com.xwl.aop;

import com.xwl.aop.config.ConfigAop;
import com.xwl.aop.service.MathCaculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xwl
 * @date 2020-02-16 18:36
 * @description
 */
public class AOPTestConfig {

	private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}

	@Test
	public void testAop() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigAop.class); // 指定主配置类
		System.out.println("容器创建完成");

		MathCaculator mathCaculator = applicationContext.getBean(MathCaculator.class);
		mathCaculator.div(10, 2);

		// 关闭容器
		applicationContext.close();
	}


}
