package com.xwl.ext.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author xwl
 * @date 2020-03-02 10:47
 * @description
 */
@Service
public class ListenerService {

	@EventListener(classes = {ApplicationEvent.class}) // 要监听ApplicationEvent这个事件及其子事件
	public void listen(ApplicationEvent event) {
		System.out.println("ListenerService...监听到的事件：" + event);
	}
}
