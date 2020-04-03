package com.tred.CpyTreding.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Trader implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String name;
	@Email
	private String email;
	
	@Min(1) @Max(50000)
	private float balance;
	@CreationTimestamp
	private Timestamp creationTime;
	//@UpdateTimestamp
	private Timestamp modificationTime;
	
	
	
	
	public Trader() {
	}
	
	public Trader(String name, String email, float balance) {
		this.name = name;
		this.email = email;
		this.balance = balance;
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
	public Timestamp getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	public Timestamp getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(Timestamp modificationTime) {
		this.modificationTime = modificationTime;
	}

	
}
