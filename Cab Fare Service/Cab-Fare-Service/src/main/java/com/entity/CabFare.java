package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cabfare")
public class CabFare {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cfid;
	private String source;
	private String destination;
	private String typeofcab;
	private int numberofseats;
	private float amount;
	public int getCfid() {
		return cfid;
	}
	public void setCfid(int cfid) {
		this.cfid = cfid;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTypeofcab() {
		return typeofcab;
	}
	public void setTypeofcab(String typeofcab) {
		this.typeofcab = typeofcab;
	}
	public int getNumberofseats() {
		return numberofseats;
	}
	public void setNumberofseats(int numberofseats) {
		this.numberofseats = numberofseats;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CabFare [cfid=" + cfid + ", source=" + source + ", destination=" + destination + ", typeofcab="
				+ typeofcab + ", numberofseats=" + numberofseats + ", amount=" + amount + "]";
	}
	public CabFare() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CabFare(int cfid, String source, String destination, String typeofcab, int numberofseats, float amount) {
		super();
		this.cfid = cfid;
		this.source = source;
		this.destination = destination;
		this.typeofcab = typeofcab;
		this.numberofseats = numberofseats;
		this.amount = amount;
	}
}
