package com.xwl.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author xwl
 * @date 2020-02-26 11:42
 * @description 这是一个切面类
 */
@Aspect // 告诉spring该类是一个切面类
public class LogAspects {

	/**
	 * 抽取公共的切入点表达式
	 * 1、本类引用：直接使用 pointCut()
	 * 2、其他类引用用：使用 com.xwl.aop.aop.LogAspects.pointCut()
	 *
	 * public int com.xwl.aop.service.MathCaculator.div(int, int)：切点表达式（指定在哪个方法切入），
	 * 其中,public是访问权限修饰符，int是返回值类型，MathCaculator是对应的类，div是对应的方法，(int, int)是参数列表
	 * public int com.xwl.aop.service.MathCaculator.*(..)，其中*表示该类中的任意方法，(..)表示任意参数，任意类型
	 */
	@Pointcut("execution(public int com.xwl.aop.service.MathCaculator.*(..))")
	public void pointCut() {

	}

	// @Before在目标方法之前切入
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		// 目标方法名
		String methodName = joinPoint.getSignature().getName();
		// 目标方法参数列表
		Object[] args = joinPoint.getArgs();
		System.out.println("目标方法名：" + methodName + "...@Before...除法运算开始。。。参数列表是：" + Arrays.asList(args));
	}

	// @After在目标方法之后切入（无论方法正常结束还是异常结束都会调用）
	@After("com.xwl.aop.aop.LogAspects.pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		// 目标方法名
		String methodName = joinPoint.getSignature().getName();
		System.out.println("目标方法名：" + methodName +"...@After...除法运算结束");
	}

	// @AfterReturning在目标方法正常返回后执行
	// 注：如果参数有JoinPoint，JoinPoint必须写在参数列表的第一位，否则spring是无法识别的
	@AfterReturning(value = "pointCut()", returning = "result") // returning指定参数接收返回值
	public void logReturn(JoinPoint joinPoint, Object result) { // result 用于接收返回值
		// 目标方法名
		String methodName = joinPoint.getSignature().getName();
		System.out.println("目标方法名：" + methodName + "...@AfterReturning...除法运算正常返回。。。返回结果是：" + result);
	}

	// @AfterThrowing在目标方法出现异常后执行
	@AfterThrowing(value = "pointCut()", throwing = "exception") // throwing指定参数接收异常信息
	public void logException(JoinPoint joinPoint, Exception exception) { // exception 用于接收异常信息
		// 目标方法名
		String methodName = joinPoint.getSignature().getName();
		System.out.println("目标方法名：" + methodName + "...@AfterThrowing...除法运算异常。。。异常信息是：" + exception);
	}
}
