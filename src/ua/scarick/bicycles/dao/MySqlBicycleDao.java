package ua.scarick.bicycles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.scarick.bicycles.entity.BicycleStorage;

public class MySqlBicycleDao implements BicycleDAO {
	
	private Connection connection;
	private String base;

	public MySqlBicycleDao(Connection connection, String dbaseFullName) {
		this.connection = connection;
		this.base = dbaseFullName;
	}

	@Override
	public List<BicycleStorage> getAllBicycles() throws SQLException {
		String query = "SELECT * FROM " + base;
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		List<BicycleStorage> bicycleList = new ArrayList<BicycleStorage>();
		while (rs.next()) {
			BicycleStorage bicycleStorage = new BicycleStorage();
			bicycleStorage.setId(rs.getInt("id"));
			bicycleStorage.setManufacturer(rs.getString("manufacturer"));
			bicycleStorage.setModel(rs.getString("model"));
			bicycleStorage.setGender(rs.getString("gender"));
			bicycleStorage.setAmount(rs.getInt("amount"));
			bicycleStorage.setLastCheck(rs.getDate("last_check"));
			
			bicycleList.add(bicycleStorage);			
		}
		rs.close();
		statement.close();
		
		return bicycleList;
	}

	@Override
	public void createBicycle(BicycleStorage bicycle) throws SQLException {
		
		String query = "INSERT INTO " + base + " (manufacturer, model, gender, amount, last_check)"
				+ " VALUES (?, ?, ?, ?, ?);";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, bicycle.getManufacturer());
		statement.setString(2, bicycle.getModel());
		statement.setString(3, bicycle.getGender());
		statement.setInt(4, bicycle.getAmount());
		statement.setDate(5, new java.sql.Date(bicycle.getLastCheck().getTime()));
		
		statement.executeUpdate();					
	}

	@Override
	public BicycleStorage getBicycle(int id) throws SQLException {
		
		String query = "SELECT * FROM " + base + " WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setInt(1, id);
		
		ResultSet rs = statement.executeQuery();
		
		BicycleStorage bicycle = new BicycleStorage();
		while (rs.next()) {
		bicycle.setId(rs.getInt("id"));
		bicycle.setManufacturer(rs.getString("manufacturer"));
		bicycle.setModel(rs.getString("model"));
		bicycle.setGender(rs.getString("gender"));
		bicycle.setAmount(rs.getInt("amount"));
		bicycle.setLastCheck(rs.getDate("last_check"));
		}
		rs.close();
		statement.close();
		
		return bicycle;		
	}

	@Override
	public void updateBicycle(BicycleStorage bicycle) throws SQLException {
		
		String query = "UPDATE " + base + " SET manufacturer=?, model=?, gender=?, amount=?, last_check=? WHERE id=?;";
		
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setString(1, bicycle.getManufacturer());
		statement.setString(2, bicycle.getModel());
		statement.setString(3, bicycle.getGender());
		statement.setInt(4, bicycle.getAmount());
		statement.setDate(5, new java.sql.Date(bicycle.getLastCheck().getTime()));
		statement.setInt(6, bicycle.getId());
		
		statement.executeUpdate();		
	}

	@Override
	public void deleteBicycle(BicycleStorage bicycle) throws SQLException {

		String query = "DELETE FROM " + base + " WHERE id=?;";
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setInt(1, bicycle.getId());
		
		statement.executeUpdate();
	}
	
	public void deleteBicycle(int id) throws SQLException {

		String query = "DELETE FROM " + base + " WHERE id=" + id + ";";
		
		PreparedStatement statement = connection.prepareStatement(query);		
		statement.executeUpdate();
	}
	
}
