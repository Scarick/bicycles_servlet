package ua.scarick.bicycles.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlDaoFactory implements DaoFactory {
	
	private String driver;
	private String dburn;
	private String dbhost;
	private String dbport;
	private String dbBaseName;
	private String dbTableName;
	private String user;
	private String password;
	
	public MySqlDaoFactory() throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(getClass().getResourceAsStream("/connection.properties"));
		driver = prop.getProperty("driver");
		dburn = prop.getProperty("dburn");
		dbhost = prop.getProperty("dbhost");
		dbport = prop.getProperty("dbport");
		dbBaseName = prop.getProperty("dbbasename");
		dbTableName = prop.getProperty("dbtablename");
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
		String dburl = dburn + dbhost + ":" + dbport + "/" + dbBaseName;
		return DriverManager.getConnection(dburl, user, password);
	}

	@Override
	public BicycleDAO getMySqlBicycleDAO(Connection connection) {
		String dbName = dbBaseName + "." + dbTableName;
		return new MySqlBicycleDao(connection, dbName);
	}

}
