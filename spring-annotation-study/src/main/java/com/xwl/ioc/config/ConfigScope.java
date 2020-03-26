package com.xwl.ioc.config;

import com.xwl.ioc.bean.Book;
import com.xwl.ioc.bean.Person;
import com.xwl.ioc.bean.SchooleFactoryBean;
import com.xwl.ioc.bean.User;
import com.xwl.ioc.condition.LinuxCondition;
import com.xwl.ioc.condition.WindowsCondition;
import com.xwl.ioc.importBean.MyImportBeanDefinitionRegistrar;
import com.xwl.ioc.importBean.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * @author xwl
 * @date 2020-02-15 18:08
 * @description
 */
@Configuration
//@Conditional({WindowsCondition.class}) // @Conditional({Condition})注解放在类上，表明只有满足该条件，这个类中的所有bean才会被注册到IOC容器中
@Import({User.class, Book.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) // 快速导入组件，id默认是组件的全类名
public class ConfigScope {


	/**
	 * @Scope 调整作用域：
	 * prototype：多实例，在每次使用的时候才会调用方法创建对象（每次获取都会重新创建），而在IOC容器启动时不会调用该方法创建对象
	 * singleton：单实例，IOC容器启动就会调用该方法创建对象放到IOC容器中，以后每次获取就是直接从IOC容器中拿（map.get()）
	 * request：同一次请求创建一个实例（web环境）
	 * session：同一个session创建一个实例（web环境）
	 *
	 * 懒加载：针对于单实例的
	 * 		单实例bean默认情况不是懒加载：在IOC容器启动时创建对象
	 * 		开启懒加载：IOC容器启动时不创建对象，在“第一次”使用（获取）bean时创建对象并放到IOC容器中
	 * @return
	 */
//	@Scope("singleton") // 指定bean的作用范围，默认是单例的
	@Lazy // 针对单实例singleton，开启懒加载模式，在IOC启动时不会创建该对象，而是在第一次使用该对象时才加载
	@Bean("person")
	public Person person() {
		System.out.println("bean的作用域默认是单实例，会在IOC容器启动时调用该方法创建对象放入IOC容器中。。。");
		System.out.println("bean的作用域如果换成是prototype即多实例，会在使用该对象的时候调用该方法创建对象，而不是在IOC容器启动时调用该方法创建对象。。。");
		return new Person("薛宝钗", 14);
	}


	/**
	 * @Conditional({Condition}): 按照一定条件判断，满足条件的就给IOC容器中注册bean
	 * 如果@Conditional({Condition})注解放在类上，表明只有满足该条件，这个类中的所有bean才会被注册到IOC容器中
	 * 需求：
	 * 如果是Windows系统，就给IOC容器中注册bill，如果是linux系统就给IOC容器中注册linus
	 */
	@Conditional({WindowsCondition.class})
	@Bean("bill")
	public Person person01() {
		return new Person("Bill Gates", 62);
	}

	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person02() {
		return new Person("Linus", 48);
	}

	/**
	 * 给IOC容器中注册组件：
	 * 1、包扫描+组件标注注解（@Controller、@Service、@Repository、@Component）[用于自己写的类]
	 * 2、@Bean[导入的第三方包里面的组件]
	 * 3、@Import[快速给容器中导入一个组件]
	 * 		1)、@Import(要导入到容器中的组件)：容器中就会自动注册这个组件，id默认是组件的全类名
	 * 		2)、ImportSelector：返回需要导入的组件的全类名数组；【详情请看：com.xwl.ioc.importBean.MyImportSelector】
	 * 		3）、ImportBeanDefinitionRegistrar：手动注册Bean到IOC容器中【详情请看：com.xwl.ioc.importBean.MyImportBeanDefinitionRegistrar】
	 * 4、使用spring提供的FactoryBean(工厂Bean)：【详情请看：com.xwl.ioc.bean.SchooleFactoryBean，测试详情请看：com.xwl.ioc.IOCTestConfigScope#testFactoryBean()】
	 * 		1)、默认获取的是调用getObject创建的对象！！！
	 * 		2)、要获取工厂Bean本身，我们需要给id前面加一个 & 标识
	 */
	@Bean
	public SchooleFactoryBean schooleFactoryBean() {
		return new SchooleFactoryBean();
	}
}
