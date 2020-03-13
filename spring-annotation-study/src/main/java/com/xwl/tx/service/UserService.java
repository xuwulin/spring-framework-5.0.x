package com.xwl.tx.service;

import com.xwl.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xwl
 * @date 2020-02-27 21:22
 * @description
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 加上@Transactional 注解，告诉spring这个方式是一个事务方法
	 */
	@Transactional
	public void insert() {
		userDao.insert();
		System.out.println("插入完成...");
//		int i = 1 / 0; // 制造异常，测试回滚
	}
}
