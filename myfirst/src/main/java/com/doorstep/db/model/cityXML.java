package com.doorstep.db.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class cityXML {


	
	@XmlElement
	private List<cityMain> lstCity;

	public List<cityMain> getLstCity() {
		return lstCity;
	}

	public void setLstCity(List<cityMain> lstCity) {
		this.lstCity = lstCity;
	}
	
}
