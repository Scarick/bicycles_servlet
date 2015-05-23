package ua.scarick.bicycles.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlDaoFactory implements DaoFactory {
	
	private String driver;
	private String dburl;
	private String user;
	private String password;
	
	public MySqlDaoFactory() throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(getClass().getResourceAsStream("/connection.properties"));
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Connection getConnection() throws SQLException {		
		return DriverManager.getConnection(dburl, user, password);
	}

	@Override
	public BicycleDAO getBicycleDAO(Connection connection) {
		
		return new MySqlBicycleDao(connection);
	}

}
