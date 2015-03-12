package com.tst.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doorstep.daoImpl.CustomerDAOImpl;
import com.doorstep.db.model.cityMain;
import com.tst.dao.CustomerDAO;
import com.tst.dao.impl.JdbcCustomerDAO;
import com.tst.model.Customer;
import com.tst.model.User;

@Controller
@RequestMapping("/helloWorld")
public class tstController {
	
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	com.doorstep.dao.CustomerDAO cust;
	
		@RequestMapping(value = "/hello", method = RequestMethod.GET)
		public String hello(ModelMap model) {
			model.addAttribute("msg", "JCG Hello World!");
			model.addAttribute("comnd",new User());
			//CustomerDAO customerDAO = new JdbcCustomerDAO();
	        Customer customer = new Customer(1, "mkyong",28);
	        customerDAO.insert(customer);
	 
	        Customer customer1 = customerDAO.findByCustomerId(1);
	        System.out.println(customer1);
			return "createUsr";
		}
		
		@RequestMapping(value = "/displayMessage/{msg}", method = RequestMethod.GET)
		public String displayMessage(@PathVariable String msg, ModelMap model) {
			int id=Integer.parseInt(msg);
		       Customer customer = new Customer(id, "mkyong",28);
		        customerDAO.insert(customer);
		 
		        Customer customer1 = customerDAO.findByCustomerId(id);
		        System.out.println(customer1);
			model.addAttribute("msg", customer1);
			return "tst";
		}
		
		@RequestMapping(value="createUser", method = RequestMethod.POST)
		public ModelAndView createUser(@ModelAttribute("user") User user,ModelMap model) {
			Customer customer = new Customer(user.getLocation(), user.getName(),user.getAge());
	        customerDAO.insert(customer);
	 
	        Customer customer1 = customerDAO.findByCustomerId(user.getLocation());
	        System.out.println(customer1);
			model.addAttribute("name",customer1.getName());
			model.addAttribute("age",customer1.getAge());
			//model.addAttribute("location",customer1.getCustId());
			System.out.println(user.getName());
			return new ModelAndView("createUsr","comnd",new User());
			//return "tst";
		}
		
		@RequestMapping(value="user", method = RequestMethod.GET)
		public ModelAndView user(){
			return new ModelAndView("createUsr","comnd",new User());
		}
		
		//@Path("/listCity")
		//@GET
		//@Produces(MediaType.APPLICATION_JSON)
		@RequestMapping(value="/listCity", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
		public List<cityMain> getListofCity()
		{
			JdbcCustomerDAO jd=new JdbcCustomerDAO();
			System.out.println(jd.findByCustomerId(1));
			Customer customer1 = customerDAO.findByCustomerId(1);
	        System.out.println(customer1);
	        
			
			return cust.listofcity();
		}
	}