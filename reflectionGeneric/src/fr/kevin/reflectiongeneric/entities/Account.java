package fr.kevin.reflectiongeneric.entities;

import fr.kevin.reflectiongeneric.entities.base.BaseEntities;

public class Account extends BaseEntities {
	private double solde = 0;
	private User user = new User();
	
	public Account() {}
	
	public Account(double solde, User user) {
		this.solde = solde;
		this.user = user;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
