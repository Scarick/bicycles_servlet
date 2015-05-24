package ua.scarick.bicycles.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.scarick.bicycles.dao.BicycleDAO;
import ua.scarick.bicycles.entity.BicycleStorage;

/**
 * Servlet implementation class EditController
 */
public class EditController extends ParentController {
	private static final long serialVersionUID = 1L;
	private BicycleDAO bicycleDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bicycleDao = getDao();
		// Get array of checked items
		String[] checkedBicycle = request.getParameterValues("checkedBicycle");
		
		if (checkedBicycle == null) {
			request.setAttribute("bicycleID", null);			
		} else if (checkedBicycle.length == 1) {			
			try {
				// Get bicycle with checked id
				BicycleStorage bicycle = bicycleDao.getBicycle(Integer.parseInt(checkedBicycle[0]));
				
				request.setAttribute("bicycle", bicycle);
			} catch (NumberFormatException e) {				
				e.printStackTrace();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			request.setAttribute("bicycleID", checkedBicycle[0]);			
		}
		request.getRequestDispatcher("WEB-INF/jsp/edit.jsp").forward(request, response);
	}
}
