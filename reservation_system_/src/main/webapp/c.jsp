<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="reservation_system_.Details"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
 HttpSession hs=request.getSession();
    String s=(String)hs.getAttribute("id");
   
    long pnr=(Long)hs.getAttribute("pnr");
    System.out.print(pnr);
    
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("desto");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	et.begin();
	
	Query q=em.createQuery("Update Details d Set d.status=?1 where PNR_=?2");
	q.setParameter(1,"Cancelled");
	q.setParameter(2, pnr);	
	q.executeUpdate();  
	
	et.commit();
	RequestDispatcher re=  request.getRequestDispatcher("/home_page.jsp");
	re.forward(request, response);

	%>

</body>
</html>