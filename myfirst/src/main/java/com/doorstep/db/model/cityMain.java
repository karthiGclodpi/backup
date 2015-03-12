package com.doorstep.db.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cityMain")
@XmlAccessorType(XmlAccessType.FIELD)
public class cityMain {

	@XmlElement
	private int intCityId;
	@XmlElement
	private String strCityName;
	
	/*public cityMain(int intCityId, String strCityName) {
		
		this.intCityId=intCityId;
		this.strCityName=strCityName;
	}*/
	public String getStrCityName() {
		return strCityName;
	}
	public void setStrCityName(String strCityName) {
		this.strCityName = strCityName;
	}
	public int getIntCityId() {
		return intCityId;
	}
	public void setIntCityId(int intCityId) {
		this.intCityId = intCityId;
	}
	@Override
	public String toString() {
		return "cityMain [intCityId=" + intCityId + ", strCityName="
				+ strCityName + "]";
	}
	
}
