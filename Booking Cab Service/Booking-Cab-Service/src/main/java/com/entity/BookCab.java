package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookcab")
public class BookCab {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int cabid;
private String cname;
private String cnumber;
private String source;
private String destination;
private String typeofcab;
private int numberofseats;
private String time;		
private float amount;
public int getCabid() {
	return cabid;
}
public void setCabid(int cabid) {
	this.cabid = cabid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCnumber() {
	return cnumber;
}
public void setCnumber(String cnumber) {
	this.cnumber = cnumber;
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
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}
public BookCab() {
	super();
	// TODO Auto-generated constructor stub
}					 

}
