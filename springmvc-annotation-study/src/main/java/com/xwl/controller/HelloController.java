package com.xwl.controller;

import com.xwl.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xwl
 * @date 2020-03-03 11:52
 * @description
 */
@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		String res = helloService.sayHello("tomcat...");
		return res;
	}

	/**
	 * 返回结果最终会和AppConfig配置类中的视图解析器拼接：/WEB-INF/views/success.jsp
	 * @return
	 */
	@RequestMapping("/suc")
	public String success() {
		System.out.println("哈哈哈成功了");
		return "success";
	}
}
