package reservation_system_;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validateuser")
public class LoginValidation extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("username");
		String pass=req.getParameter("password");
		
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("desto");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et=em.getTransaction(); 
		
		Query q=em.createQuery("select a from User a where a.id=?1 and a.password=?2"); 
		q.setParameter(1, id);
		q.setParameter(2, pass);
		
	     List<User> l=	q.getResultList();
	     
	    if(l.size()>0) {
	    	
	    	HttpSession hs=req.getSession();
	    	hs.setAttribute("id", id);
	    	System.out.println("login successfull");
	    	 RequestDispatcher rd=req.getRequestDispatcher("/home_page.jsp");
	    	 rd.forward(req, resp); 
	    }
	    else {
	    	System.out.println("invalid details");
	    	 RequestDispatcher rd=req.getRequestDispatcher("/login_page.html");
	    	 rd.forward(req, resp); 
	    }
		
	}

}
