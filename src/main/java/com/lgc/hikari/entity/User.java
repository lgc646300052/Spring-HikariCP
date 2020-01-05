package com.lgc.hikari.entity;

import java.util.Date;

import com.lgc.hikari.entity.basic.Field;
import com.lgc.hikari.entity.basic.db.DB;
import com.lgc.hikari.entity.basic.db.DateTimeDBField;
import com.lgc.hikari.entity.basic.db.EnumDBField;
import com.lgc.hikari.entity.basic.db.NumberDBField;
import com.lgc.hikari.entity.basic.db.VarcharDBField;
import com.lgc.hikari.entity.basic.view.ViewField;

public class User {
	private Field<String> name = new Field<String>(new ViewField("v_name"), new VarcharDBField("d_name"));
	private Field<Integer> age = new Field<Integer>(new ViewField("v_age"), new NumberDBField("d_age"));
	private Field<Sex> sex = new Field<Sex>(new ViewField("v_sex"), new EnumDBField("d_sex"));
	private Field<Date> bothday = new Field<Date>(new ViewField("v_bothday"), new DateTimeDBField("d_bothday"));
	
	public Field<String> getName() {
		return name;
	}

	public void setName(Field<String> name) {
		this.name = name;
	}

	public Field<Integer> getAge() {
		return age;
	}

	public void setAge(Field<Integer> age) {
		this.age = age;
	}

	public Field<Sex> getSex() {
		return sex;
	}

	public void setSex(Field<Sex> sex) {
		this.sex = sex;
	}

	public Field<Date> getBothday() {
		return bothday;
	}

	public void setBothday(Field<Date> bothday) {
		this.bothday = bothday;
	}

	public static void main(String[] args) {
		// TODO 测试
		User u = new User();
		String sql = DB.selectField("user"
				, u.getName()
				, u.getAge()
				, u.getBothday()
				, u.getSex()
				);
		System.out.println(sql);
	}

}
