package com.tred.CpyTreding.dto;

import java.text.SimpleDateFormat;

import com.tred.CpyTreding.model.Trader;

public class TraderDTO {
	private Long id;
	private String name;
	private String email;
	private float balance;

	private String creationTime;
	private String modificationTime;

	public TraderDTO(Trader trader) {
		super();
		this.id = trader.getId();
		this.name = trader.getName();
		this.email = trader.getEmail();
		this.balance = trader.getBalance();
		this.creationTime = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(trader.getCreationTime());
		if(trader.getModificationTime()!=null) {
		this.modificationTime = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(trader.getModificationTime());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(String modificationTime) {
		this.modificationTime = modificationTime;
	}

}
