package com.xwl.ioc.config;

import com.xwl.ioc.bean.Cat;
import com.xwl.ioc.bean.Friend;
import com.xwl.ioc.bean.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xwl
 * @date 2020-02-15 20:53
 * @description
 * Bean的生命周期：bean创建--->初始化--->销毁过程
 *
 * 	容器管理Bean的生命周期；
 * 	我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化方法和销毁方法
 *
 * 	对象创建（通过构造函数）：
 * 		单实例：在容器启动的时候创建
 * 		多实例：在每次获取的时候创建
 *
 *  ==>（在初始化之 前 会调用spring的BeanPostProcessor.postProcessBeforeInitialization()方法）
 * 	初始化：
 * 		对象创建完成并赋值好，调用初始化方法
 * 	==>（在初始化之 后 会调用spring的BeanPostProcessor.postProcessAfterInitialization()方法）
 * 	销毁：
 * 		单实例：容器关闭时销毁
 * 		多实例：容器不会管理这个bean,容器不会调用销毁方法
 *
 * 	实现bean的初始化和销毁方法的方式（四种）：
 * 	1、指定初始化和销毁方法：
 * 		1）、如果是使用xml配置文件，则指定init-method和destory-method
 * 		2）、如果是使用注解，则使用initMethod和destroyMethod指定初始化和销毁方法
 * 	2、通过让Bean实现InitializingBean(定义初始化逻辑)，DisposableBean(定义销毁逻辑)
 * 	3、可以使用JSR250：
 * 		@PostConstruct： 在bean创建完成并完成赋值后来执行初始化方法
 *		@PreDestroy: 在容器销毁bean之前通知我们进行清理工作
 *	4、BeanPostProcessor：bean的后置处理器；
 *		在bean初始化前后进行一些处理工作：
 *			postProcessBeforeInitialization：在bean初始化之前调用
 *			postProcessAfterInitialization：在bean初始化之后调用
 *
 *	遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，
 *  一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
 *
 *  BeanPostProcessor原理:
 *  	populateBean(beanName, mbd, instanceWrapper); // 给bean进行属性赋值
 *  	initializeBean：初始化方法执行顺序：
 *  		{
 *   	 	 applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *   	 	 invokeInitMethods(beanName, wrappedBean, mbd); // 执行自定义初始化
 *   	 	 applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *  		}
 *  Spring底层对 BeanPostProcessor 的使用；
 *   	bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async,xxx等都是用了BeanPostProcessor;
 *
 */
@Configuration
@Import({MyBeanPostProcessor.class})
public class ConfigLifeCycle {

	@Bean(initMethod = "init", destroyMethod = "destory")
	public Friend friend() {
		return new Friend();
	}

	@Bean
	public Cat cat() {
		return new Cat();
	}

}
