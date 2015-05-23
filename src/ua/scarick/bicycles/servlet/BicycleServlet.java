package ua.scarick.bicycles.servlet;

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
 * Servlet implementation class BicycleServlet
 */
public class BicycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BicycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			
		try {
			DaoFactory daoFactory = new MySqlDaoFactory();
			Connection connection = daoFactory.getConnection();
			BicycleDAO bicycleDao = daoFactory.getBicycleDAO(connection);
			List<BicycleStorage> bicycleStorageList = bicycleDao.getAllBicycles();
		
			request.setAttribute("bicycleStorageList", bicycleStorageList);
			request.getRequestDispatcher("WEB-INF/jsp/bicycle.jsp").forward(request, response);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
