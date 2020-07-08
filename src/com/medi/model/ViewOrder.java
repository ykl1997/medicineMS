package com.medi.model;

public class ViewOrder {
	String cusName;
	String mediName;
	int num;
	double totalPrince;

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getMediName() {
		return mediName;
	}

	public void setMediName(String mediName) {
		this.mediName = mediName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getTotalPrince() {
		return totalPrince;
	}

	public void setTotalPrince(double totalPrince) {
		this.totalPrince = totalPrince;
	}

	public ViewOrder(String cusName, String mediName, int num, double totalPrince) {
		super();
		this.cusName = cusName;
		this.mediName = mediName;
		this.num = num;
		this.totalPrince = totalPrince;
	}

	public ViewOrder() {
		super();
	}

}
