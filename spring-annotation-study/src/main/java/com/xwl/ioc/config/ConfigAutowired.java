package com.xwl.ioc.config;

import com.xwl.ioc.bean.Car;
import com.xwl.ioc.bean.School;
import com.xwl.ioc.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author xwl
 * @date 2020-02-16 19:05
 * @description
 * 自动装配：
 * 		spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值；
 * 	1)、@Autowired自动注入，这是spring中的注解
 * 		1)、默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class);找到就给该属性bookDao赋值
 * 		2)、如果找到了多个相同类型的组件（如，该类中注册的bookDao2也是属于BookDao这一类型的组件），
 * 		    再将属性的名称(bookDao)作为组件的id去查找：applicationContext.getBean("bookDao");
 * 		3)、@Qualifier(“bookDao2”)：使用@Qualifier()注解明确指定要装配的组件id，而不是使用默认的属性名去装配
 * 		4)、自动装配默认一定要将属性赋好值，否则就会报错
 * 			可以使用@Autowired的一个属性required来调整：@Autowired(required = false)
 * 		5)、@Primary注解：让spring进行自动装配的时候默认使用首选的bean
 * 			也可以继续使用@Qualifier("")注解指定要装配的bean的名字
 * 		public class BookService {
 * 			@Autowired
 * 			private BookDao bookDao;
 * 		}
 *
 * 	2)、spring还支持使用@Resource(JSR250)和@Inject(JSR330)，这两者都是java规范的注解
 * 		@Resource: 可以和@Autowired一样实现自动装配的功能；默认是按照组件名称来装配的
 * 				   但是不支持@Primary注解和没有required这一属性
 *      @Inject: 需要导入javax.inject的包，和@Autowired一样实现自动装配的功能，支持@Primary注解
 *      		 但是没有required这一属性
 *
 * 注：@Autowired、@Resource、@Inject三者的区别：@Autowired是spring定义的注解，@Resource、@Inject是java规范中的注解
 * 3)、@Autowired可以用在：构造器，参数，方法，属性上，不管放在哪个位置都是从IOC容器中获取参数组件的值
 *		1)、标注在方法位置上：@Bean+方法参数，参数从容器中获取，默认不写@Autowired效果都是一样的，都能自动从IOC中获取
 *		2)、标注在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 *
 * 4)、自定义组件想要使用spring容器底层的一些组件（如：ApplicationContext、BeanFactory、xxx）;
 * 	  	自定义组件实现xxxAware，在创建对象的时候，会调用接口规定的方法注入相关组件
 * 	    xxxAware：其功能是使用xxxAwareProcessor后置处理器来实现的，每一种xxxAware都有对应的xxxAwareProcessor
 * 	    比如：ApplicationContextAware===>ApplicationContextAwareProcessor
 *
 * 自动注入注解为什么能生效？
 * 答：依靠AutowiredAnnotationBeanPostProcessor来解析完成自动装配功能，即由它来解析@Autowired、@Resource、@Inject等
 */
@Configuration
@ComponentScan({"com.xwl.ioc.controller", "com.xwl.ioc.service", "com.xwl.ioc.dao", "com.xwl.ioc.bean"})
public class ConfigAutowired {

	@Primary
	@Bean("bookDao2")
	public BookDao bookDao() {
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}

	/**
	 * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
	 * @param car
	 * @return
	 */
	@Bean
	public School school(/*@Autowired*/ Car car) { // 此参数中的@Autowired可以不写，默认就是从IOC容器中获取
		School school = new School();
		school.setCar(car);
		return school;
	}
}
