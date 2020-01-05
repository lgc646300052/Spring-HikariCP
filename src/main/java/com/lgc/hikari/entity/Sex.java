package com.lgc.hikari.entity;

/**
 * 性别枚举
 * @author 64630
 *
 */
public enum Sex {
	/** 男 */
	man(true),
	/** 女 */
	felmax(false);
	private boolean sex;
	
	public boolean isSex() {
		return sex;
	}

	Sex(boolean sex) {
		this.sex = sex;
	}

}
