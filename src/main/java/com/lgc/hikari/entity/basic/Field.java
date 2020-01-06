package com.lgc.hikari.entity.basic;

import com.lgc.hikari.entity.basic.db.DBField;
import com.lgc.hikari.entity.basic.view.ViewField;

/**
 * 字段类
 * @author 64630
 *
 */
public class Field<T> {
	private ViewField viewField;
	private DBField dbField;
	/** 字段值 */
	private T value;
	public ViewField getViewField() {
		return viewField;
	}
	public void setViewField(ViewField viewField) {
		this.viewField = viewField;
	}
	public DBField getDbField() {
		return dbField;
	}
	public void setDbField(DBField dbField) {
		this.dbField = dbField;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Field(ViewField viewField, DBField dbField) {
		super();
		this.viewField = viewField;
		this.dbField = dbField;
	}

}
