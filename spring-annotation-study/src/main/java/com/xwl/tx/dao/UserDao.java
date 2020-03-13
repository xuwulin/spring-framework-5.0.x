package com.xwl.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author xwl
 * @date 2020-02-27 21:22
 * @description
 */
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert() {
		String sql = "INSERT INTO tbl_user (username, age) VALUES(?, ?)";
		// 增删改都是调用这个方法
		jdbcTemplate.update(sql, "薛宝钗", 14);
	}
}
