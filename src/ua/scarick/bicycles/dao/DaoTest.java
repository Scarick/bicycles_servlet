package ua.scarick.bicycles.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.Date;
import org.junit.Test;




import ua.scarick.bicycles.entity.BicycleStorage;

public class DaoTest {
	
	
	@Test
	public void testGetBicycle() throws Exception {
		DaoFactory daoFactory = new MySqlDaoFactory();
		BicycleStorage bicycle;
		try {
			Connection con = daoFactory.getConnection(); 
			BicycleDAO dao = daoFactory.getMySqlBicycleDAO(con);
			bicycle = dao.getBicycle(1);
					assertNotNull(con);
		} finally {
		
		}
		
		assertNotNull(bicycle);
		
	}
	
	@Test
	public void testUpdateBicycle() throws Exception {
		DaoFactory daoFactory = new MySqlDaoFactory();
		BicycleStorage bicycle;
		try {
			Connection con = daoFactory.getConnection(); 
			BicycleDAO dao = daoFactory.getMySqlBicycleDAO(con);
			bicycle = new BicycleStorage();
			bicycle.setId(5);
			bicycle.setManufacturer("Test");
			bicycle.setModel("Test");
			bicycle.setGender("M");
			bicycle.setAmount(5);
			bicycle.setLastCheck(new java.sql.Date(new Date().getTime()));
			
			dao.updateBicycle(bicycle);
		} finally {
		
		}
		
		assertNotNull(bicycle);		
	}
	
	@Test
	public void testCreateBicycle() throws Exception {
		DaoFactory daoFactory = new MySqlDaoFactory();
		BicycleStorage bicycle;
		try {
			Connection con = daoFactory.getConnection(); 
			BicycleDAO dao = daoFactory.getMySqlBicycleDAO(con);
			bicycle = new BicycleStorage();
			bicycle.setId(5);
			bicycle.setManufacturer("Test");
			bicycle.setModel("Test");
			bicycle.setGender("M");
			bicycle.setAmount(5);
			bicycle.setLastCheck(new java.sql.Date(new Date().getTime()));
			
			dao.createBicycle(bicycle);
		} finally {
		
		}
		
		assertNotNull(bicycle);
		
	}

}
