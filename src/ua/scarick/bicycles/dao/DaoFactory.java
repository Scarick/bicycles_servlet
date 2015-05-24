package ua.scarick.bicycles.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
	
	public Connection getConnection() throws SQLException;
	
	public 	BicycleDAO getMySqlBicycleDAO(Connection connection);
}