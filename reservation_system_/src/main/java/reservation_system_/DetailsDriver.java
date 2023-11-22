package reservation_system_;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/reserve1")
public class DetailsDriver extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		String fromP = req.getParameter("from");
		String desti = req.getParameter("to");
		Date date =  Date.valueOf(req.getParameter("date"));
		String tName = req.getParameter("trainName");
		int number = Integer.parseInt(req.getParameter("trainNumber"));
		String cls = req.getParameter("class");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("desto");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Details details = new Details();
		details.setName(name);
		details.setGender(gender);
		details.setAge(age);
		details.setFromPlace(fromP);
		details.setDestination(desti);
		details.setDate(date);
		details.setTrainName(tName);
		details.setTrainNo(number);
		details.setClassType(cls);
		details.setStatus("conformed");
		
		
		HttpSession hs=req.getSession();
	    String s=(String) hs.getAttribute("id");
	    System.out.println(s);
	    details.setId(s);
	
		et.begin();
		em.merge(details);
		et.commit();
	
		RequestDispatcher rd =req.getRequestDispatcher("/history.jsp");
		rd.forward(req, resp);
		System.out.println("Booked");
		
	}

}
