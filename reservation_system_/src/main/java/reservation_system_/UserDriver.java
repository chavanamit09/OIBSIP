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

@WebServlet("/resisterme")
public class UserDriver extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email=req.getParameter("email");
		String id=req.getParameter("userId");
		String pass=req.getParameter("password");
		String name=req.getParameter("name");
		long contact=Long.parseLong(req.getParameter("contact"));
		
		User u=new User();
		u.setId(id);
		u.setEmail(email);
		u.setMobileNo(contact);
		u.setPassword(pass);
		u.setName(name);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("desto");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		System.out.println("user resistred ");
		
	}
	

}
