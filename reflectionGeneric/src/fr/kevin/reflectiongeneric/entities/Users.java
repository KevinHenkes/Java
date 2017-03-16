package fr.kevin.reflectiongeneric.entities;

import fr.kevin.reflectiongeneric.entities.base.BaseEntities;

public class Users implements BaseEntities {

	private int id = 0;
	private String name = "";
	private String birthday = "";

	public Users() {}

	public Users(String name, String birthday, int id) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
