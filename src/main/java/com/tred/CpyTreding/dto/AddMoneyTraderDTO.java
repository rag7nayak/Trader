package com.tred.CpyTreding.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class AddMoneyTraderDTO {
	
	@Email
	private String email;
	@Min(1) @Max(50000)
	private float balance;

	public AddMoneyTraderDTO(String email, float balance) {
		this.email = email;
		this.balance = balance;
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

}
