package com.lgc.hikari.entity.basic.db;

/**
 * varchar类型的数据库字段
 * @author 64630
 *
 */
public class EnumDBField extends DBField {

	public EnumDBField(String field) {
		super(field, DBFieldType.VARCHAR);
	}
	
	public String like(String value) {
		return field() +" LIKE "+ value;
	}

}
