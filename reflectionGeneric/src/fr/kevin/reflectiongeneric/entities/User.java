package fr.kevin.reflectiongeneric.entities;

import java.util.Date;

import fr.kevin.reflectiongeneric.entities.base.BaseEntities;

public class User extends BaseEntities {

	private String name = "";
	private Date birthday = new Date();

	public User() {}

	public User(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
