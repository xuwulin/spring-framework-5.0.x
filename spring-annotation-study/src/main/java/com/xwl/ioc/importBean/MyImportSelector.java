package com.xwl.ioc.importBean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xwl
 * @date 2020-02-15 19:45
 * @description 自定义逻辑返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {
	/**
	 *
	 * @param importingClassMetadata 当前标注@Import注解的类中的所有注解信息
	 * @return 返回值就是要导入到IOC容器中的组件的全类名
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.xwl.ioc.bean.Student", "com.xwl.ioc.bean.Teacher"};
	}
}
