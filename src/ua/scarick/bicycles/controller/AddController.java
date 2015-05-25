package ua.scarick.bicycles.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.scarick.bicycles.entity.BicycleStorage;

/**
 * Servlet implementation class AddServlet
 */
public class AddController extends ParentController {
	private static final long serialVersionUID = 1L;	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		bicycleDao = getDao();			
		
		if (request.getParameter("id").isEmpty()) {	
			try {
				// Get bicycle parameters from form
				BicycleStorage bicycle = new BicycleStorage();
				
				bicycle.setManufacturer(request.getParameter("manufacturer"));
				bicycle.setModel(request.getParameter("model"));
				bicycle.setGender(request.getParameter("gender"));
				bicycle.setAmount(Integer.parseInt(request.getParameter("amount")));
				bicycle.setLastCheck(dateFormat(request.getParameter("lastCheck")));
				
				// Create new bicycle in DB
				bicycleDao.createBicycle(bicycle);				
				
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
		} else {
			try {
			
				// Get bicycle parameters from form
				BicycleStorage bicycle = new BicycleStorage();
				
				bicycle.setId(Integer.parseInt(request.getParameter("id")));
				bicycle.setManufacturer(request.getParameter("manufacturer"));
				bicycle.setModel(request.getParameter("model"));
				bicycle.setGender(request.getParameter("gender"));
				bicycle.setAmount(Integer.parseInt(request.getParameter("amount")));
				bicycle.setLastCheck(dateFormat(request.getParameter("lastCheck")));
				
				// Update bicycle in DB
				bicycleDao.updateBicycle(bicycle);
				
			} catch (Exception e) {			
				e.printStackTrace();				
			}
		}
		
		response.sendRedirect(request.getContextPath());
//		request.getRequestDispatcher("/").forward(request, response);;
	}

	

}
