package com.xwl;

import com.xwl.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xwl
 * @date 2020-02-12 20:37
 * @description
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(StartConfiguration.class);
		Person person = (Person) annotationConfigApplicationContext.getBean("person");
		System.out.println(person.sayHello());
	}
}
