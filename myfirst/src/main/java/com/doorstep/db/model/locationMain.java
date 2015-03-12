package com.doorstep.db.model;

public class locationMain {

	private int intLocationID;
	private String strLocationName;
	private int intCityID;
	public int getIntLocationID() {
		return intLocationID;
	}
	public void setIntLocationID(int intLocationID) {
		this.intLocationID = intLocationID;
	}
	public String getStrLocationName() {
		return strLocationName;
	}
	public void setStrLocationName(String strLocationName) {
		this.strLocationName = strLocationName;
	}
	public int getIntCityID() {
		return intCityID;
	}
	public void setIntCityID(int intCityID) {
		this.intCityID = intCityID;
	} 
	@Override
	public String toString() { 
		return "locationMain [intLocationID=" + intLocationID
				+ ", strLocationName=" + strLocationName + ", intCityID="
				+ intCityID + "]";
	}
	
} 
