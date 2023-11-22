package reservation_system_;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginvalidateofficial")
public class OfficialLoginValidation extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user ="official_work";
		String pass="Official@123";
		
		String s=req.getParameter("username");
		String p=req.getParameter("password");	
		
		if(s.equals(user) && p.equals(pass)) {
			RequestDispatcher rd= req.getRequestDispatcher("/official_home_page.html");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd= req.getRequestDispatcher("/official_login.html");
			rd.forward(req, resp);
		}
		
	}

}
