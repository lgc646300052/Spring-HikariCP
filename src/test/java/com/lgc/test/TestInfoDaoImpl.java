package com.lgc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lgc.hikari.dao.impl.InfoDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestInfoDaoImpl {
	@Autowired
	private InfoDaoImpl dao;
	
	@Test
	public void add() {
		String name = "aaa";
		dao.addInfo(name);
	}
}
