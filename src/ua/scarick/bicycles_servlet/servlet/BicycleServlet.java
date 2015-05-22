package ua.scarick.bicycles_servlet.servlet;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.scarick.bicycles_servlet.entity.BicycleStorage;


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
		// TODO Auto-generated method stub
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		
		try {
		// Display List of bicycles
		List<BicycleStorage> bicycleStorageList = em.createQuery(
				"SELECT b FROM BicycleStorage b",
				BicycleStorage.class).getResultList();
		request.setAttribute("bicycles", bicycleStorageList);
		request.getRequestDispatcher("WEB-INF/jsp/bicycle.jsp").forward(request, response);;
		} finally {
			if (em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
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
