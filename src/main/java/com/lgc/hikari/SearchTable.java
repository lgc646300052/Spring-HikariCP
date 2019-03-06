package com.lgc.hikari;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgc.hikari.dao.impl.SearchDaoImpl;

public class SearchTable extends HttpServlet {
	SearchDaoImpl searchDao = new SearchDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long start = System.nanoTime();
		String content = searchDao.getAll();
		resp.getWriter().println(content);
		long end = System.nanoTime();
		resp.addHeader("timeConsuming", String.valueOf(end - start));
	}

}
