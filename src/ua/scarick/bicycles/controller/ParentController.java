package ua.scarick.bicycles.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.scarick.bicycles.dao.BicycleDAO;
import ua.scarick.bicycles.dao.DaoFactory;
import ua.scarick.bicycles.dao.MySqlDaoFactory;

/**
 * Servlet implementation class ParentController
 */
public class ParentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected DaoFactory daoFactory;
	protected Connection connection;
	protected BicycleDAO bicycleDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParentController() {
        super();
     // Get bicycleDao
        try {
			daoFactory = new MySqlDaoFactory();
			connection = daoFactory.getConnection();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
		bicycleDao = daoFactory.getBicycleDAO(connection);
    }	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
