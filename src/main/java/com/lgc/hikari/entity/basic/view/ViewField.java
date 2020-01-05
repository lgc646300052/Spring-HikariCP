package com.lgc.hikari.entity.basic.view;

/**
 * 视图中的字段
 * @author 64630
 *
 */
public class ViewField {
	/**
	 * 字段名
	 */
	protected String field;
	public String field() {
		return field;
	}
	public void field(String field) {
		this.field = field;
	}
	public ViewField(String field) {
		super();
		this.field = field;
	}

}
