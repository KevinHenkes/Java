package fr.kevin.reflectiongeneric.entities;

import fr.kevin.reflectiongeneric.entities.base.BaseEntities;

public class Account implements BaseEntities {
	
	private int id = 0;
	private double solde = 0;
	private Users users = new Users();
	
	public Account() {}
	
	public Account(double solde, int id, Users users) {
		this.id = id;
		this.solde = solde;
		this.users = users;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
