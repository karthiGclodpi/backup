package com.doorstep.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doorstep.dao.CustomerDAO;
import com.doorstep.db.model.cityMain;
import com.doorstep.db.model.locationMain;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private DataSource dataSource;

	@Override
	public List<cityMain> listofcity() {

		List<cityMain> city = new ArrayList<cityMain>();
		String sql = "select intCityID , strCityName from citymain";
		cityMain getcity = null;
		Connection conn = null;

		try {
			conn = dataSource.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 getcity = new cityMain();
				getcity.setIntCityId(rs.getInt("intCityID"));
				getcity.setStrCityName(rs.getString("strCityName"));
				city.add(getcity);
			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return city;

	}

	@Override
	public List<locationMain> listoflocation(int cityID) {
		// TODO Auto-generated method stub
		
		List<locationMain> listofLoc= new ArrayList<locationMain>();
		String sql = "select intLocationID,strLocationName,intCityID from locationmain where intCityID=?";
		locationMain locmain = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cityID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				locmain = new locationMain();
				locmain.setIntLocationID(rs.getInt("intLocationID"));
				locmain.setStrLocationName(rs.getString("strLocationName"));
				locmain.setIntCityID(rs.getInt("intCityID"));
				listofLoc.add(locmain);
			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return listofLoc;
	}

}
