package com.sergey.hometask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Item {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int item_number;
	
	private String name;
	
	private int amount;
	
	private Long code;
	
	public int getItem_number() {
		return item_number;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void deposit(int amount) {
		this.amount += amount;
	}
	
	public void withdrawAmount(int amount) { 
		this.amount -= amount;
	}
	public Long getCode() {
		return code;
	}
	
	public void setItem_number(int item_number) {
		this.item_number = item_number;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	

}
