package ua.scarick.bicycles_servlet.dao;

import java.sql.SQLException;
import java.util.List;

import ua.scarick.bicycles_servlet.entity.BicycleStorage;

public interface BicycleDAO {
	
	// CRUD for BicycleStorage
	public List<BicycleStorage> getAllBicycles() throws SQLException;
	public BicycleStorage createBicycle() throws SQLException;
	public BicycleStorage getBicycle(int id) throws SQLException;
	public void updateBicycle(BicycleStorage bicycle) throws SQLException;
	public void deleteBicycle(BicycleStorage bicycle) throws SQLException;
}