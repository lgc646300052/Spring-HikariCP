package com.lgc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lgc.hikari.dao.impl.SearchDaoImpl;
import com.zaxxer.hikari.HikariDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDao {
	@Autowired
	HikariDataSource ds;
	
	@Autowired
	SearchDaoImpl dao;
	
	@Test
	public void searchDao() {
		if (ds == null) {
			System.out.println("null");
		} else {
			System.out.println("Not null");
			long start = System.currentTimeMillis();
			String resultStr = dao.getAll();
			long end = System.currentTimeMillis();
			System.out.println("Time diff:"+ (end - start) +", result length:"+ resultStr.length() +", byte size"+ resultStr.getBytes().length);
		}
	}

}
