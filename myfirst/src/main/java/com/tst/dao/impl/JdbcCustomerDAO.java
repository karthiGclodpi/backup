package com.tst.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tst.dao.CustomerDAO;
import com.tst.model.Customer;
@Component
public class JdbcCustomerDAO implements CustomerDAO {

	@Autowired
	private DataSource dataSource;
	 
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	@Override
	public void insert(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CUSTOMERTST " +
				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		//Connection conn = null;
		JdbcTemplate jdbctemplet=new JdbcTemplate(dataSource);
		Object[] args = new Object[] {customer.getCustId(), customer.getName(), customer.getAge()};
		try{
		int out=jdbctemplet.update(sql, args);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
        /*
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();
 
		} catch (Exception e) {
			System.out.println(e);;
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}*/
	}

	@Override
	public Customer findByCustomerId(int custId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CUSTOMERTST WHERE CUST_ID = ?";
		Customer customer = null;
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(
					rs.getInt("CUST_ID"),
					rs.getString("NAME"), 
					rs.getInt("Age")
				);
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		return customer;

	}
}