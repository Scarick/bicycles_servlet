package ua.scarick.bicycles_servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.scarick.bicycles_servlet.entity.BicycleStorage;

public class MySqlBicycleDao implements BicycleDAO {
	
	private Connection connection;

	public MySqlBicycleDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<BicycleStorage> getAllBicycles() throws SQLException {
		String query = "SELECT * FROM akvelon.bicycle_storage";
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
	public BicycleStorage addBicycle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BicycleStorage getBicycle(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBicycle(BicycleStorage bicycle) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBicycle(BicycleStorage bicycle) throws SQLException {
		// TODO Auto-generated method stub

	}

}
