package com.xwl.tx;

import com.xwl.tx.config.ConfigTx;
import com.xwl.tx.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xwl
 * @date 2020-02-27 21:31
 * @description
 */
public class TxConfigTest {
	private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}

	@Test
	public void testTx() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigTx.class); // 指定主配置类
		System.out.println("容器创建完成");

		UserService userService = applicationContext.getBean(UserService.class);
		userService.insert();

		// 关闭容器
		applicationContext.close();
	}
}
