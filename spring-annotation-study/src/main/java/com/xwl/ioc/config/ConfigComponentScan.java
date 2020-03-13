package com.xwl.ioc.config;

import com.xwl.ioc.bean.Person;
import org.springframework.context.annotation.*;

/**
 * @author xwl
 * @date 2020-02-12 22:30
 * @description 配置类，等同于配置文件beans.xml
 * 注：该类也会被加载到IOC容器中，id为类名首字母小写，即mainConfig
 */
@Configuration // 此注解的作用是告诉spring这是一个配置类
// 注：@ComponentScan这是一个可以重复的注解（即在一个类中可以使用多个@ComponentScan注解），需要jdk1.8以上才支持，jdk1.8以下需要使用@ComponentScans注解实现这个重复注解的功能
@ComponentScan(value = "com.xwl.ioc")
// 使用注解的方式配置要扫描的包（value值即为要扫描的包路径），相当于beans.xml中的<context:component-scan base-package="com.xwl"></context:component-scan>

/*@ComponentScan(value = "com.xwl",
		excludeFilters = { // excludeFilters = Filter[]，指定扫描的时候按照什么规则“排除”哪些组件
				// FilterType.ANNOTATION：按照注解（常用）
				// FilterType.ASSIGNABLE_TYPE：按照类型
				// FilterType.ASPECTJ：按照ASPECTJ表达式
				// FilterType.REGEX：按照正则表达式
				// FilterType.CUSTOM：按照自定义规则
				@ComponentScan.Filter(
						type = FilterType.ANNOTATION, // type指定以哪种方式排查，此处是以注解的方式排除
						classes = {Controller.class, Service.class} // classes指定哪些注解，是一个数组，此处表示加了@Controller注解和@Service注解的组件不会被加载到IOC容器中
				),
				@ComponentScan.Filter(
						type = FilterType.ASSIGNABLE_TYPE, // type指定以哪种方式排查，此处是以类型的方式排除
						classes = {BookService.class}
				)
		}
)*/

/*@ComponentScan(value = "com.xwl",
		includeFilters = { // includeFilters = Filter[]，指定扫描的时候按照什么规则“只加载”哪些组件
				@ComponentScan.Filter(
						type = FilterType.ANNOTATION, // type指定以哪种方式加载，此处是以注解的方式加载
						classes = {Controller.class, Service.class} // classes指定哪些注解，是一个数组，此处表示只有加了@Controller注解或@Service注解的组件会被加载到IOC容器中
				),
				@ComponentScan.Filter(
						type = FilterType.CUSTOM, // type指定以哪种方式加载，此处是以自定义的方式
						classes = {MyTypeFilter.class}
				)
		},
		useDefaultFilters = false // 必须要禁用使用默认过滤规则，includeFilters才能生效
)*/

// jdk1.8及以上可以在一个类中重复使用@ComponentScan注解
// jdk1.8以下只能使用@ComponentScans = ComponentScan[]来实现
/*@ComponentScans(
		value = {
				@ComponentScan(value = "com.xwl",
						excludeFilters = { // excludeFilters = Filter[]，指定扫描的时候按照什么规则“排除”哪些组件
								@ComponentScan.Filter(
										type = FilterType.ANNOTATION, // type指定以哪种方式排查，此处是以注解的方式排除
										classes = {Controller.class, Service.class} // classes指定哪些注解，是一个数组，此处表示加了@Controller注解和@Service注解的组件不会被加载到IOC容器中
								)
						}
				),
				@ComponentScan()
		}
)*/
public class ConfigComponentScan {

	@Bean("person1") // 此注解的作用是在容器中注册一个bean，类型为返回值的类型，id是默认使用方法名作为id，也可以在()中指定名字，相当于beans.xml中的<bean>标签
	public Person person() {
		return new Person("林黛玉", 12);
	}

}
