package com.xwl.ioc.importBean;

import com.xwl.ioc.bean.Collage;
import com.xwl.ioc.bean.School;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xwl
 * @date 2020-02-15 19:57
 * @description
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	/**
	 *
	 * @param importingClassMetadata 当前类的注解信息
	 * @param registry BeanDefinition注册类
	 *                 把所有需要添加到容器中的bean；调用BeanDefinitionRegistry.registerBeanDefinition收到注册进来
	 *
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean student = registry.containsBeanDefinition("com.xwl.ioc.bean.Student");
		boolean teacher = registry.containsBeanDefinition("com.xwl.ioc.bean.Teacher");
		if (student && teacher) {
			// 指定注册bean的定义信息：（Bean的类型，作用域等）
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Collage.class);
			// 给IOC容器中手动注册一个bean，id为：collage
			registry.registerBeanDefinition("collage", rootBeanDefinition);
		}

	}
}
