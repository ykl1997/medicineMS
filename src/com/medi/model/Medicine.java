package com.medi.model;

import java.util.Date;

public class Medicine {
	int mediId;
	String mediName;
	String munifac;
	Date muniDate;
	String faction;
	double price;
	Date deadLine;
	int num;
	String position;

	public Medicine(int mediId, String mediName, String munifac, Date muniDate, String faction, double price,
			Date deadLine, int num, String position) {
		super();
		this.mediId = mediId;
		this.mediName = mediName;
		this.munifac = munifac;
		this.muniDate = muniDate;
		this.faction = faction;
		this.price = price;
		this.deadLine = deadLine;
		this.num = num;
		this.position = position;
	}

	public Medicine() {
		super();
	}

	public int getMediId() {
		return mediId;
	}

	public void setMediId(int mediId) {
		this.mediId = mediId;
	}

	public String getMediName() {
		return mediName;
	}

	public void setMediName(String mediName) {
		this.mediName = mediName;
	}

	public String getMunifac() {
		return munifac;
	}

	public void setMunifac(String munifac) {
		this.munifac = munifac;
	}

	public Date getMuniDate() {
		return muniDate;
	}

	public void setMuniDate(Date muniDate) {
		this.muniDate = muniDate;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
