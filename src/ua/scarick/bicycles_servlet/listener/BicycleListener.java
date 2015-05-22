package ua.scarick.bicycles_servlet.listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class BicycleListener
 *
 */
public class BicycleListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public BicycleListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	EntityManagerFactory emf = (EntityManagerFactory) arg0.getServletContext().getAttribute("emf");
    	emf.close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bicycles_servlet");
    	arg0.getServletContext().setAttribute("emf", emf);
    }
	
}
