package com.xwl.ext;

import com.xwl.ext.bean.BigDog;
import com.xwl.ioc.bean.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @author xwl
 * @date 2020-03-01 13:14
 * @description
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	/**
	 * 通过测试证明：postProcessBeanDefinitionRegistry方法先于postProcessBeanFactory方法执行
	 * @param registry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()...Bean的数量：" + registry.getBeanDefinitionCount());
		// 还可以手动给容器中注册bean对象
		// 方法一
//		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(BigDog.class);
//		registry.registerBeanDefinition("bigDog", rootBeanDefinition);
		// 方法二
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(BigDog.class).getBeanDefinition();
		registry.registerBeanDefinition("bigDog", beanDefinition);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory()...Bean的数量：" + beanFactory.getBeanDefinitionCount());
	}
}
