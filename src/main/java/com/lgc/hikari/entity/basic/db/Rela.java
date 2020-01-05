package com.lgc.hikari.entity.basic.db;

/**
 * 关系运算符枚举
 * @author 64630
 *
 */
public enum Rela {
	NOT(" NOT "),
	AND(" AND "),
	OR(" OR ");
	
	private String rela;
	public String getRela() {
		return rela;
	}
	Rela(String rela) {
		this.rela = rela;
	}

}
