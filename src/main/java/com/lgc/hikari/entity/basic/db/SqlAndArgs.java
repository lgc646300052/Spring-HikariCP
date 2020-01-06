package com.lgc.hikari.entity.basic.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SQL与参数
 * @author 64630
 *
 */
public class SqlAndArgs {
	private StringBuilder sql;
	private List<Object> args;
	public StringBuilder sql() {
		return sql;
	}
	public void sql(StringBuilder sql) {
		this.sql = sql;
	}
	public List<Object> args() {
		return args;
	}
	public void args(List<Object> args) {
		this.args = args;
	}
	public SqlAndArgs() {
		super();
		this.sql = new StringBuilder();
		this.args = new ArrayList<Object>(2);
	}
	public SqlAndArgs(String sql, List<Object> args) {
		super();
		this.sql = new StringBuilder(sql);
		this.args = args;
	}
	public SqlAndArgs(String sql, Object... arg) {
		super();
		this.sql = new StringBuilder(sql);
		this.args = Collections.singletonList(arg);
	}
	public SqlAndArgs(StringBuilder sql, List<Object> args) {
		super();
		this.sql = new StringBuilder(sql);
		this.args = args;
	}
	public SqlAndArgs(StringBuilder sql, Object... arg) {
		super();
		this.sql = new StringBuilder(sql);
		this.args = Collections.singletonList(arg);
	}

}
