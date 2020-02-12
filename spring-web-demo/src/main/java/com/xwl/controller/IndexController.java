package com.xwl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xwl
 * @date 2020-02-12 20:34
 * @description
 */
@RestController
public class IndexController {

	@GetMapping("index")
	public String index() {
		return "hello world";
	}
}
