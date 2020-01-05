package com.lgc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
	@Test
	public void test() {
		ApplicationContext c = new ClassPathXmlApplicationContext("application.xml");
	}

}
