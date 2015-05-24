package ua.scarick.bicycles.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.scarick.bicycles.dao.BicycleDAO;
import ua.scarick.bicycles.entity.BicycleStorage;

/**
 * Servlet implementation class AddServlet
 */
public class AddController extends ParentController {
	private static final long serialVersionUID = 1L;
	private BicycleDAO bicycleDao;
       
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
				
		String editedBicycle = request.getParameter("id");	
		PrintWriter out = response.getWriter();
		if (editedBicycle.isEmpty()) {	
			try {
				
				BicycleStorage bicycle = new BicycleStorage();
				bicycle.setManufacturer(request.getParameter("manufacturer"));
				bicycle.setModel(request.getParameter("model"));
				bicycle.setGender(request.getParameter("gender"));
				bicycle.setAmount(Integer.parseInt(request.getParameter("amount")));
				bicycle.setLastCheck(dateFormat(request.getParameter("lastCheck")));
			
				out.print(bicycle);
			
//				bicycleDao.createBicycle(bicycle);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			try {
			
				BicycleStorage bicycle = new BicycleStorage();
				bicycle.setManufacturer(request.getParameter("manufacturer"));
				bicycle.setModel(request.getParameter("model"));
				bicycle.setGender(request.getParameter("gender"));
				bicycle.setAmount(Integer.parseInt(request.getParameter("amount")));
				bicycle.setLastCheck(dateFormat(request.getParameter("lastCheck")));
			
				out.print(bicycle);
			
				bicycleDao.updateBicycle(bicycle);
				
			} catch (Exception e) {			
				e.printStackTrace();				
			}
		}
		
//		request.getRequestDispatcher("/").forward(request, response);
	}

	

}
