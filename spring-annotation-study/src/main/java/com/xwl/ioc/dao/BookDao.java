package com.xwl.ioc.dao;

import org.springframework.stereotype.Repository;

/**
 * @author xwl
 * @date 2020-02-15 15:56
 * @description
 */
@Repository // 该类加上此注解，会自动被加载到IOC容器中，id为类名首字母小写，即bookDao
public class BookDao {
	private String lable = "1";

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	@Override
	public String toString() {
		return "BookDao{" +
				"lable='" + lable + '\'' +
				'}';
	}
}
