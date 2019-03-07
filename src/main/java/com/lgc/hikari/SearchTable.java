package com.lgc.hikari;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lgc.hikari.dao.impl.SearchDaoImpl;

@Controller
public class SearchTable extends HttpServlet {
	public static int instanceCount = 0;
	
	@Autowired
	SearchDaoImpl searchDao;
	
	public SearchDaoImpl getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDaoImpl searchDao) {
		this.searchDao = searchDao;
	}
	
	public SearchTable() {
		super();
		instanceCount++;
		System.out.println(">>>>>>instanceCount:"+ instanceCount +", "+ this.toString());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long start = System.nanoTime();
		String content = searchDao.getAll();
		resp.getWriter().println(content);
		long end = System.nanoTime();
		resp.addHeader("timeConsuming", String.valueOf(end - start));
	}

}
