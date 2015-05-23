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

	public MySqlBicycleDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<BicycleStorage> getAllBicycles() throws SQLException {
		String query = "SELECT * FROM akvelon.bicycle_storage;";
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
		return bicycleList;
	}

	@Override
	public BicycleStorage createBicycle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BicycleStorage getBicycle(int id) throws SQLException {
		
		String query = "SELECT * FROM akvelon.bicycle_storage WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setInt(1, id);
		
		ResultSet rs = statement.executeQuery();
		
		BicycleStorage bicycle = new BicycleStorage();
		
		bicycle.setId(rs.getInt("id"));
		bicycle.setManufacturer(rs.getString("manufacturer"));
		bicycle.setModel(rs.getString("model"));
		bicycle.setGender(rs.getString("gender"));
		bicycle.setAmount(rs.getInt("amount"));
		bicycle.setLastCheck(rs.getDate("last_check"));
		return bicycle;
	}

	@Override
	public void updateBicycle(BicycleStorage bicycle) throws SQLException {
		
		String query = "UPDATE akvelon.bicycle_storage SET ?,?,?,?,? WHERE id=?;";
		
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setString(1, "manufacturer=" + bicycle.getManufacturer());
		statement.setString(2, "model=" + bicycle.getModel());
		statement.setString(3, "gender=" + bicycle.getGender());
		statement.setString(4, "amount=" + bicycle.getAmount());
		statement.setString(5, "last_check=" + bicycle.getLastCheck());
		statement.setInt(6, bicycle.getId());
		
		statement.executeUpdate(query);
	}

	@Override
	public void deleteBicycle(BicycleStorage bicycle) throws SQLException {

		String query = "DELETE FROM akvelon.bicycle_storage WHERE id=?;";
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setInt(1, bicycle.getId());
		
		statement.executeUpdate(query);
	}
}
