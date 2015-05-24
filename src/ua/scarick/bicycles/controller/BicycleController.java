package ua.scarick.bicycles.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.scarick.bicycles.dao.BicycleDAO;
import ua.scarick.bicycles.entity.BicycleStorage;

/**
 * Servlet implementation class EditController
 */
public class BicycleController extends ParentController {
	private static final long serialVersionUID = 1L;
	private BicycleDAO bicycleDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BicycleController() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bicycleDao = daoFactory.getMySqlBicycleDAO(connection);
		
		try {			
			List<BicycleStorage> bicycleStorageList = bicycleDao.getAllBicycles();	
			request.setAttribute("bicycleStorageList", bicycleStorageList);
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		request.getRequestDispatcher("WEB-INF/jsp/bicycle.jsp").forward(request, response);
		
	}	
}
