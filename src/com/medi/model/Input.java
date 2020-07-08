package com.medi.model;

public class Input {
	int id;
	int mediId;
	int inNum;
	int eId;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
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

	public int getInNum() {
		return inNum;
	}

	public void setInNum(int inNum) {
		this.inNum = inNum;
	}

	public Input(int id, int mediId, int inNum, int eId) {
		super();
		this.id = id;
		this.mediId = mediId;
		this.inNum = inNum;
		this.eId = eId;
	}

	public Input() {
		super();
	}

}
