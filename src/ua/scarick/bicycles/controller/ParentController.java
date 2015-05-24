package ua.scarick.bicycles.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
    }	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	public Date dateFormat(String s) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(s);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;		
	}
	
	
	public BicycleDAO getDao() {
		return daoFactory.getMySqlBicycleDAO(connection);		
	}

}
