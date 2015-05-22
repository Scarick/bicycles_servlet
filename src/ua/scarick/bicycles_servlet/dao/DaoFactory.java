package ua.scarick.bicycles_servlet.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
	
	public Connection getConnection() throws SQLException;
	
	public 	BicycleDAO getBicycleDAO(Connection connection);
}
