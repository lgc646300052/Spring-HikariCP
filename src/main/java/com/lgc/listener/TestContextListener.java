package com.lgc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.lgc.hikari.SearchTable;
import com.lgc.hikari.dao.impl.SearchDaoImpl;

public class TestContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		System.out.println("++++++++++++++++++++++++自定义contextListener destroy++++++++++++++++"+ event.getServletContext());
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		System.out.println("++++++++++++++++++++++++自定义contextListener init++++++++++++++++"+ event.getServletContext().getInitParameter("contextConfigLocation"));
		WebApplicationContext appContext = ContextLoaderListener.getCurrentWebApplicationContext();
		String[] beanNames = appContext.getBeanDefinitionNames();
		if (beanNames != null) {
			for (String bn : beanNames) {
				System.out.println(bn);
			}
		}
		
		SearchDaoImpl dao = appContext.getBean("searchDaoImpl", SearchDaoImpl.class);
		System.out.println("------------searchDaoImpl.dataSource:"+ dao.getDs());
		SearchTable controller = appContext.getBean("searchTable", SearchTable.class);
		System.out.println("------------searchTable.dao:"+ controller.getSearchDao());
	}

}
