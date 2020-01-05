package com.lgc.hikari.entity.basic.db;

public class DateTimeDBField extends DBField {

	public DateTimeDBField(String field) {
		super(field, DBFieldType.DECIMAL);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 区间
	 * @param minValue 最小值
	 * @param maxValue 最大值（不包含）
	 * @return
	 */
	public String betweed(Number minValue, Number maxValue) {
		return " ("+ field() +" BETWEEN "+ minValue +" AND "+ maxValue +") ";
	}

}
