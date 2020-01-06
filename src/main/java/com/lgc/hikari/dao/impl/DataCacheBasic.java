package com.lgc.hikari.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public abstract class DataCacheBasic<T> {
	private static Logger log = LoggerFactory.getLogger(DataCacheBasic.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Map<String, T> cache = new HashMap<>();

	protected T query(String sql, ResultSetExtractor<T> extractor) throws DataAccessException {
		long start = System.currentTimeMillis();
		T result = cache.get(sql);
		if (result == null) {
			// 缓存中没有，需要到库里查
			result = jdbcTemplate.query(sql, extractor);
//			log.info("+++++++++++ Access DataBase +++++++++ diff:"+ (System.currentTimeMillis() - start));
			cache.put(sql, result);
		} else {
//			log.info("Read cache, diff:"+ (System.currentTimeMillis() - start));
		}
		return result;
	}
	

}
