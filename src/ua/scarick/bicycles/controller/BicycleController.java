package ua.scarick.bicycles.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.scarick.bicycles.dao.BicycleDAO;
import ua.scarick.bicycles.dao.DaoFactory;
import ua.scarick.bicycles.dao.MySqlDaoFactory;
import ua.scarick.bicycles.entity.BicycleStorage;

/**
 * Servlet implementation class EditController
 */
public class BicycleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoFactory daoFactory;
	Connection connection;
	BicycleDAO bicycleDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BicycleController() {
        super();
        // TODO Auto-generated constructor stub
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			List<BicycleStorage> bicycleStorageList = bicycleDao.getAllBicycles();	
			request.setAttribute("bicycleStorageList", bicycleStorageList);
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		request.getRequestDispatcher("WEB-INF/jsp/bicycle.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	
	
}
