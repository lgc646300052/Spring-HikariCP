package com.lgc.hikari.entity.basic.db;

import com.lgc.hikari.entity.basic.Field;

public class DB {
	/**
	 * 构造SELECT语句的列名部分<br />
	 * 如果fields是null或者是空数组则查询出所有列（即SELECT *）
	 * @param fields 列名集合
	 * @return
	 */
	public static String selectField(DBField... fields) {
		if (fields == null || fields.length == 0) {
			return "SELECT * ";
		}
		StringBuilder select = new StringBuilder("SELECT ");
		select.append(fields[0].field());
		for (int i = 1; i < fields.length; i++) {
			select.append(", "+ fields[i].field());
		}
		select.append(" ");
		return select.toString();
	}
	
	public static String selectField(Field... fields) {
		if (fields == null || fields.length == 0) {
			return "SELECT * ";
		}
		DBField[] dbFields = new DBField[fields.length];
		for (int i = 0; i < fields.length; i++) {
			dbFields[i] = fields[i].getDbField();
		}
		return selectField(dbFields);
	}
	
	public static String selectField(String table, DBField... fields) {
		String select = selectField(fields);
		return select += (table +" ");
	}
	
	public static String selectField(String table, Field... fields) {
		String select = selectField(fields);
		return select += ("FROM "+ table +" ");
	}
	
}
