package ua.scarick.bicycles.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class DeleteController
 */
public class DeleteController extends ParentController {
	private static final long serialVersionUID = 1L;	
       
    /**
     * @see ParentController#ParentController()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		bicycleDao = getDao();
		
		// Get JSON array
		String bicyclesToDelete = request.getParameter("jsonCheckboxesChecked");		
		if (bicyclesToDelete != null) {
			
			Object jsonObj = JSONValue.parse(bicyclesToDelete);
			JSONArray jsonArray = (JSONArray) jsonObj;
			
			for (int i=0; i < jsonArray.size(); i++) {				
				try {
					bicycleDao.deleteBicycle(Integer.parseInt(jsonArray.get(i).toString()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		} 
		
		request.getRequestDispatcher("/WEB-INF/jsp/bicycle.jsp").forward(request, response);	
	}

}
