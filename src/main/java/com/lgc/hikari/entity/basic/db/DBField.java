package com.lgc.hikari.entity.basic.db;

/**
 * 数据库表中对应的一列
 * @author 64630
 *
 */
public abstract class DBField {
	/** 列名 */
	protected String field;
	/** 数据类型 */
	protected DBFieldType type;
	public String field() {
		return field;
	}
	public void field(String field) {
		this.field = field;
	}
	public DBFieldType type() {
		return type;
	}
	public void type(DBFieldType type) {
		this.type = type;
	}
	public DBField(String field, DBFieldType type) {
		super();
		this.field = field;
		this.type = type;
	}
	
	/**
	 * 等于
	 * @param value 值
	 * @return
	 */
	public SqlAndArgs eq(Object value) {
		return new SqlAndArgs(field() +" = ?", value);
	}
	
	/**
	 * 包含在values集合中
	 * @param values 集合
	 * @return
	 */
	public SqlAndArgs in(Object[] values) {
		if (values == null || values.length == 0) {
			return new SqlAndArgs();
		}
		StringBuilder in = new StringBuilder(values[0].toString());
		for (int i = 1; i < values.length; i++) {
			in.append(", ?");
		}
		return new SqlAndArgs(field() +" IN ("+ in.toString() +")", values);
	}
}
