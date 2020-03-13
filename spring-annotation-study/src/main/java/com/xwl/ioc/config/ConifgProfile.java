package com.xwl.ioc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author xwl
 * @date 2020-02-25 21:22
 * @description
 * Profile: spring为我们提供的可以根据当前环境，动态地激活和切换一系列组件的功能
 * 比如：开发环境、测试环境、生产环境
 * 比如：数据源1、数据源2、数据源3等
 *
 * @Profile: 指定组件在哪个环境的情况下才能被注册到容器中
 * 该例中有三个数据源，分别是test、dev、prod环境，只有在对应的环境被激活，其对应的数据源才能被假如到IOC容器中
 * 1)、加了环境标识【如@Profile("test")】的bean，只有这个环境被激活的时候才能注册到容器中，默认是default环境,即@Profile("default")
 * 2)、当@Profile("test")写配置类上，只有是指定环境的时候，整个配置类中的所有配置才开始生效（才会被加载进IOC容器中）
 * 3)、没有标注环境标识的bean（即，没有使用@Profile注解标注的bean）在任何环境下都会被加载进IOC容器中
 * 4)、如何切换环境呢？
 * 		1、使用命令行动态参数：-Dspring.profiles.active=test  标识切换到test环境
 * 		2、使用代码的方式激活某种环境，详见IOCTestConfigProfile.java中的testProfile2
 */
@Configuration
// 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中，加载完外部的配置文件以后使用@Value("${}")取出配置文件中的值
@PropertySource("classpath:dbConfig.properties") // 加载配置文件
public class ConifgProfile implements EmbeddedValueResolverAware {

	/**
	 * 第一种方式读取配置文件中属性的值，使用@Value("${db.user}") 获取用户名
	 */
	@Value("${db.user}")
	private String user;

	private String driverClass;

	@Value("${db.url.test}")
	private String testUrl;

	@Value("${db.url.dev}")
	private String devUrl;

	@Value("${db.url.prod}")
	private String prodUrl;

	/**
	 * 第三种方式读取配置文件中属性的值，实现EmbeddedValueResolverAware（值解析器），使用值解析器解析表达式
	 * @param resolver 值解析器
	 */
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// 使用值解析器解析配置文件中的属性的值
		driverClass = resolver.resolveStringValue("${db.driverClass}");
	}

	/**
	 * 测试数据源
	 * 第二种方式读取配置文件中属性的值在参数位置使用 @Value("${db.password}") 获取密码
	 * @return
	 * @throws PropertyVetoException
	 */
	@Profile("test") // 给该bean加上一个环境标识
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value("${db.password}") String password) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(testUrl);
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	/**
	 * 开发数据源
	 * @return
	 * @throws PropertyVetoException
	 */
	@Profile("dev") // 给该bean加上一个环境标识
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("${db.password}") String password) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(devUrl);
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	/**
	 * 生产数据源
	 * @return
	 * @throws PropertyVetoException
	 */
	@Profile("prod") // 给该bean加上一个环境标识
	@Bean("prodDataSource")
	public DataSource dataSourceProd(@Value("${db.password}") String password) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(prodUrl);
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}


}
