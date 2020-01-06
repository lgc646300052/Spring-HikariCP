package com.lgc.hikari.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InfoDaoImpl {
	@Autowired
	private JdbcTemplate jt;
	
	@Transactional
	public int addInfo(String name) {
		String sql = "INSERT INTO INFO (PRODUCT) VALUES (?)";
		
		int result = jt.update(sql, name);
		return result / 0;
	}

}
