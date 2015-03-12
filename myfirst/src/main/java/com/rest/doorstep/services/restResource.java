package com.rest.doorstep.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doorstep.db.model.cityMain;
import com.doorstep.db.model.cityXML;
import com.doorstep.db.model.locationMain;
import com.tst.model.User;

@Component
@Path("res")
public class restResource {

	@Autowired
	com.doorstep.dao.CustomerDAO customerDAO;

	@Path("new")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getit() {
		User usr = new User();
		usr.setAge(98);
		usr.setName("gates");
		return usr;
	}

	@Path("listCity")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<cityMain> getListofCity() {

		cityXML lxml = new cityXML();
		lxml.setLstCity(customerDAO.listofcity());
		return customerDAO.listofcity();
	}

	@Path("listLocation")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<locationMain> getListofLocation(@QueryParam("cityId") int cityId) {

		// cityXML lxml=new cityXML();
		// lxml.setLstCity(customerDAO.listofcity());
		return customerDAO.listoflocation(cityId);
	}
}
