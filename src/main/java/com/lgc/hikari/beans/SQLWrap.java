package com.lgc.hikari.beans;

import java.util.Arrays;

public class SQLWrap {
	private String sql;
	private Object[] parameters;
	private int hashCode = 0;
	
	public String getSql() {
		return sql;
	}

	public Object[] getParameters() {
		return parameters;
	}
	
	public SQLWrap(String sql, Object[] parameters) {
		this.sql = sql;
		this.parameters = parameters;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (! (obj instanceof SQLWrap))
			return false;
		SQLWrap p = (SQLWrap) obj;
		if (sql.equals(p.sql)
				&& Arrays.equals(parameters, p.parameters))
			return true;
		else
			return false;
	}
	
	@Override
	public synchronized int hashCode() {
		if (hashCode == 0) {
			int result = 31 + sql.hashCode();
			result = 31 * result + Arrays.hashCode(parameters);
			hashCode = result;
		}
		return hashCode;
	}

}
