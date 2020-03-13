package com.xwl.ioc.config;

import com.xwl.ioc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xwl
 * @date 2020-02-16 18:34
 * @description
 */
@Configuration
// 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中，加载完外部的配置文件以后使用@Value("${}")取出配置文件中的值
@PropertySource(value = {"person.properties"}) // 默认是加载根路径下
public class ConfigPropertyValue {

	@Bean
	public Person person() {
		return new Person();
	}
}
