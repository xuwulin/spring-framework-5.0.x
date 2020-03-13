package com.xwl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author xwl
 * @date 2020-03-03 11:40
 * @description
 * 根容器的配置类（相当于以前xml版的Spring的配置文件：applicationContext.xml），作为父容器
 * 父子容器效果：父容器用于扫描所有的业务逻辑组件，dao接口，数据源，及其作事务控制等功能
 */
// 父容器，扫描com.xwl下所有的类，排除标注 @Controller 注解的类，标注@Controller的类交给springmvc（web容器）扫描
@ComponentScan(value = "com.xwl", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
public class RootConfig {
}
