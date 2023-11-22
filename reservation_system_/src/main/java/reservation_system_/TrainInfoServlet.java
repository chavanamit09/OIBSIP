package reservation_system_;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TrainInfoServlet")
public class TrainInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int trainNumber =Integer.parseInt( req.getParameter("trainNumber"));
		
		String trainName = fetchTrainNameFromDatabase(trainNumber);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(trainName);
    }

	EntityManagerFactory emf= Persistence.createEntityManagerFactory("desto");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
    private String fetchTrainNameFromDatabase(int trainNumber) {
    	Trains t= em.find(Trains.class, trainNumber);
    	return t.getTrainName();
        // Implement your Hibernate logic to fetch the train name based on the train number from the database
        // Return the train name
    }
}