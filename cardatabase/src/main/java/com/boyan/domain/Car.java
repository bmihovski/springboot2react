package com.boyan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String brand, model, color, registerNumber;
	private int year, price;
	
	public Car() {}

	public Car(String brand, String model, String color, String registerNumber, int year, int price) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year = year;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
