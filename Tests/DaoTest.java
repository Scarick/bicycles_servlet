package ua.scarick.bicycles.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

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

}
