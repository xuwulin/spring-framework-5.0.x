package com.xwl.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xwl
 * @date 2020-03-02 10:31
 * @description
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> { // ApplicationEvent是我们要监听的事件
	/**
	 * 当容器中发布此事件以后会调用此方法
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("收到事件：" + event);
	}
}
