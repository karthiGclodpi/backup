package com.doorstep.dao;

import java.util.List;

import com.doorstep.db.model.cityMain;
import com.doorstep.db.model.locationMain;

public interface CustomerDAO {

	public List<cityMain> listofcity(); 
	public List<locationMain> listoflocation(int cityID);
}
