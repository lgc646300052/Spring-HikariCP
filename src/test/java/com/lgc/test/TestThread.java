package com.lgc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lgc.hikari.dao.impl.SearchDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestThread {
	private static Logger log = LoggerFactory.getLogger(TestThread.class);
	@Autowired
	private SearchDaoImpl dao;
	
	@Test
	public void test() {
		Thread t1 = new Thread(new Worker(dao));
		Thread t2 = new Thread(new Worker(dao));
		Thread t3 = new Thread(new Worker(dao));
		Thread t4 = new Thread(new Worker(dao));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Worker implements Runnable {
	private static Logger log = LoggerFactory.getLogger(Worker.class);
	private SearchDaoImpl dao;
	
	public Worker(SearchDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		dao.getAll();
	}
	
}
