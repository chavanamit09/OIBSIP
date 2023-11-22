package reservation_system_;



import java.io.IOException;

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
@WebServlet("/trainname")
public class TrainDriver extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String s=req.getParameter("name");
		int num=Integer.parseInt(req.getParameter("num"));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("desto");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		

			 Trains t=new Trains();
			 
			 t.setTrainName(s);
			 t.setTrainNo(num);
			 
			 et.begin();
			 em.persist(t);
			 et.commit();
			 
			 RequestDispatcher rd=req.getRequestDispatcher("/trainsName.html");
			 rd.forward(req, resp);
		 }
		
		 
		 
		
	}


