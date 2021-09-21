package com.testsimulator.testsimulator.domain.enums;

public enum TypeUser {
	
	ADMIN(1, "Administrator"),
	FREE_USER(2, "User: not subscriber"),
	SUBSCRIBER_USER(3, "User: subscriber");
	
	private int cod;
	private String description;
	
	private TypeUser(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static TypeUser toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TypeUser x : TypeUser.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id: " + cod + " not valid");
	}

}
