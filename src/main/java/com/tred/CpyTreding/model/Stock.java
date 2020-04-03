package com.tred.CpyTreding.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock implements Serializable {

	@Id
	private String simbol;

	private String name;

	public Stock() {
	}

	public Stock(String simbol, String name) {
		super();
		this.simbol = simbol;
		this.name = name;
	}

	public String getSimbol() {
		return simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
