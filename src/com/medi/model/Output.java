package com.medi.model;

import java.util.Date;

public class Output {
	int id;
	int mediId;
	int outnum;
	int cid;
	double totalPrince;
	Date outDate;

	public Output() {
		super();
	}

	public Output(int id, int mediId, int outnum, int cid, double totalPrince, Date outDate) {
		super();
		this.id = id;
		this.mediId = mediId;
		this.outnum = outnum;
		this.cid = cid;
		this.totalPrince = totalPrince;
		this.outDate = outDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMediId() {
		return mediId;
	}

	public void setMediId(int mediId) {
		this.mediId = mediId;
	}

	public int getOutnum() {
		return outnum;
	}

	public void setOutnum(int outnum) {
		this.outnum = outnum;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public double getTotalPrince() {
		return totalPrince;
	}

	public void setTotalPrince(double totalPrince) {
		this.totalPrince = totalPrince;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
}
