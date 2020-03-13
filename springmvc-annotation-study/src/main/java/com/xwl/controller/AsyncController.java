package com.xwl.controller;

import com.xwl.service.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author xwl
 * @date 2020-03-03 14:24
 * @description springmvc的异步处理
 */
@Controller
public class AsyncController {

	/**
	 * 1、控制器返回Callable
	 * 2、Spring异步处理，将Callable 提交到 TaskExecutor 使用一个隔离的线程进行执行
	 * 3、DispatcherServlet和所有的Filter退出web容器的线程，但是response 保持打开状态；
	 * 4、Callable返回结果，SpringMVC将请求重新派发给容器，恢复之前的处理；
	 * 5、根据Callable返回的结果。SpringMVC继续进行视图渲染流程等（从收请求-视图渲染）。
	 * <p>
	 * preHandle...
	 * /async01
	 * 主线程开始...Thread[http-nio-8080-exec-7,5,main]当前时间：1583217200153
	 * 主线程结束...Thread[http-nio-8080-exec-7,5,main]当前时间：1583217200156
	 * =========DispatcherServlet及所有的Filter退出线程============================
	 * <p>
	 * ================等待Callable执行==========
	 * 副线程开始...Thread[MvcAsync1,5,main]当前时间：1583217200167
	 * 副线程结束...Thread[MvcAsync1,5,main]当前时间：1583217202168
	 * ================Callable执行完成==========
	 * <p>
	 * ================再次收到之前重发过来的请求========
	 * preHandle...
	 * /async01
	 * postHandle...（Callable的之前的返回值就是目标方法的返回值）
	 * afterCompletion...
	 * <p>
	 * 异步的拦截器:
	 * 1）、原生API的AsyncListener
	 * 2）、SpringMVC：实现AsyncHandlerInterceptor；
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/async01")
	public Callable<String> async01() {
		System.out.println("主线程开始..." + Thread.currentThread() + "当前时间：" + System.currentTimeMillis());
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("副线程开始..." + Thread.currentThread() + "当前时间：" + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("副线程结束..." + Thread.currentThread() + "当前时间：" + System.currentTimeMillis());
				return "Callable<String> async01";
			}
		};
		System.out.println("主线程结束..." + Thread.currentThread() + "当前时间：" + System.currentTimeMillis());
		return callable;
	}

	@ResponseBody
	@RequestMapping("/createOrder")
	public DeferredResult<Object> createOrder() {
		DeferredResult<Object> deferredResult = new DeferredResult<>((long) 3000, "create fail...");
		// 保存至DeferredResultQueue队列中
		DeferredResultQueue.save(deferredResult);
		return deferredResult;
	}

	@ResponseBody
	@RequestMapping("/create")
	public String create() {
		// 创建订单
		String order = UUID.randomUUID().toString();
		// 取出队列中保存的数据
		DeferredResult<Object> deferredResult = DeferredResultQueue.get();
		deferredResult.setResult(order);
		return "success===>" + order;
	}

}
