package com.xwl;

import com.xwl.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xwl
 * @date 2020-02-12 20:17
 * @description
 */
@Configuration
public class StartConfiguration {

	@Bean(name = "person")
	public Person initBean() {
		return new Person();
	}
}
