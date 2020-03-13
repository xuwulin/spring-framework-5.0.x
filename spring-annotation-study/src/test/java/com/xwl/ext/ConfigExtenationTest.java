package com.xwl.ext;

import com.xwl.ext.config.ConfigExtention;
import com.xwl.tx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xwl
 * @date 2020-02-27 21:31
 * @description
 */
public class ConfigExtenationTest {
	private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}

	@Test
	public void testExt() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigExtention.class); // 指定主配置类
		System.out.println("容器创建完成");

		// 发布一个事件
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
		});
		// 关闭容器
		applicationContext.close();
		System.out.println("容器已关闭");
	}
}
