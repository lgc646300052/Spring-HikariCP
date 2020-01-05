package com.lgc.hikari.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.lgc.hikari.dao.extractor.StringResultSetExtractor;

@Service
public class SearchDaoImpl2 extends DataCacheBasic<String> {
	private static Logger log = LoggerFactory.getLogger(SearchDaoImpl2.class);
	
	private static String TABLE = "events_waits_summary_by_thread_by_event_name";
	private static String SQL = "SELECT * FROM "+ TABLE;
	// 将结果集解析为String字符串的解析器
	private ResultSetExtractor<String> stringExtractor = new StringResultSetExtractor();
	
	public String getAll() {
		return query(SQL, stringExtractor);
	}

}
