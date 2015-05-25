package ua.scarick.bicycles.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String bicyclesToDelete = request.getParameter("jsonCheckboxesChecked");
		if (bicyclesToDelete != null) {
			out.print("It's OK");
			Object jsonObj = JSONValue.parse(bicyclesToDelete);
			JSONArray jsonArray = (JSONArray) jsonObj;
			
			List<String> list = new ArrayList<String>();
			for (int i=0; i < jsonArray.size(); i++) {
			    list.add(jsonArray.get(i).toString());		    
			}			
			
		} else {
			out.print("Not OK");
		}
		
		
		
	}

}
