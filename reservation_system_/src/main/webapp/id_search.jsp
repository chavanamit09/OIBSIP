<!DOCTYPE html>
<%@page import="reservation_system_.User"%>
<%@page import="reservation_system_.Details"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<html>
<head>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    .navbar {
      background-color: #333;
      overflow: hidden;
    }

    .navbar a {
      float: left;
      display: block;
      color: white;
      text-align: center;
      padding: 14px 20px;
      text-decoration: none;
    }

    .navbar a:hover {
      background-color: #ddd;
      color: black;
    }

    .search-container {
      float: left;
    }

    input[type=text] {
      padding: 6px;
      margin-top: 8px;
      margin-bottom: 8px;
      margin-right: 16px;
      border: none;
    }

    @media screen and (max-width: 600px) {
      .navbar a, .search-container {
        float: none;
        display: block;
        text-align: left;
        width: 100%;
        margin: 0;
        padding: 10px;
      }
      .search-container {
        margin-top: 8px;
      }
    }
    
     table {
	padding-left:300;
	padding-top:50;
	padding-right:200;
	border-color: orange;
	padding-bottom: 50;
}
th ,td {
	padding: 10px;
}
  </style>
</head>
<body>

<%
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("desto");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	String s=request.getParameter("id");
	User u=em.find(User.class, s);
    %>

<div class="navbar">
   <div class="search-container">
    <form action="id_search.jsp">
      <input type="text" placeholder="Search User ID">
    </form>
  </div>
  <a href="trainsName.html">Manage Train</a>
  <a href="login_page.html">Logout</a>
</div>



  <h1 align="center">User Information</h1>
        
        <% 
      HttpSession ht=request.getSession();
        ht.setAttribute("id", u.getId());
        if(u!=null){
        %>
         <table align="center" border="10">
        <tr>
        	<th>ID</th>
        	<th>Name</th>
            <th>Email</th>
            <th>Contact</th>
            <th>history</th>
        </tr>
        <tr>
        	<td><%=s %></td>
            <td><%=u.getName()%></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getMobileNo() %></td>
            <td><a href="mybookings.jsp">Bookings</a></td>
        </tr>
    </table>
    <%
    }
    
    else{
    %>
    <h1>No Account Available</h1>
    <%} %>
    

</body>
</html>
