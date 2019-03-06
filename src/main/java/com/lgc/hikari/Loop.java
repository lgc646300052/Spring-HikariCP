package com.lgc.hikari;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loop extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long start = System.nanoTime();
		int count = 1000;
		String strC = req.getParameter("c");
		if (strC != null) {
			count = Integer.parseInt(strC);
		}
		for (int i = 0; i < count; i++) {
			Object obj = new Object();
		}
		long end = System.nanoTime();
		resp.addHeader("timeConsuming", String.valueOf(end - start));
	}

}
