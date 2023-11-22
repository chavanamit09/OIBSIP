 <!DOCTYPE html>
<%@page import="reservation_system_.Details"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<html>
<head>
    <title>Online Reservation System</title>
    <style>
        body {
            background-image: url('https://images.unsplash.com/uploads/1413387158190559d80f7/6108b580?auto=format&fit=crop&q=80&w=2070&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'); /* Replace 'train_background.jpg' with your background image file path */
            background-size: cover;
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
            font-size: 16px;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #007BFF;
        }

        .user-id {
            float: right;
            font-size: 16px;
            color: white;
            padding: 14px 16px;
        }

       .container {
            align-content: center;
        }
         
        h1 {
            color: gray;
        }
        
         table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
        
    </style>
</head>
<body>
   
    <%
    
    HttpSession hs=request.getSession();
    String s=(String)hs.getAttribute("id");
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("desto");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Query q=em.createQuery("select a from Details a where a.id=?1");
	q.setParameter(1, s );
	
	List<Details> l=q.getResultList();
    
    %>
    <div class="navbar">
    	<a href="home_page.jsp">Home</a>
    	<a href="login_page.html"> Go to login</a>
        <a href="reservation.jsp">Book Ticket</a>
         <a href="cancel.jsp">Cancel Ticket</a>
         <a href="confermation.jsp">My Bookings</a>
        
        <div class="user-id"><%=s %></div>
    </div>

    <div class="container">
        <h1 align="center">Online Reservation System</h1>
        
        <% 
        if(l.size()>0){
        	
        for(Details d:l){
        %>
         <table>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Train Number</th>
            <th>From</th>
            <th>To</th>
            <th>Date</th>
            <th>PNR</th>
            <th>Status</th>
        </tr>
        <tr>
            <td><%=d.getName()%></td>
            <td><%=d.getAge() %></td>
            <td><%=d.getGender() %></td>
            <td><%=d.getTrainNo()%></td>
            <td><%=d.getFromPlace() %></td>
            <td><%=d.getDestination() %></td>
            <td><%=d.getDate() %></td>
            <td><%=d.getPNR_() %></td>
            <td><%=d.getStatus() %></td>
        </tr>
        
    </table>
    <%} 
    }
    
    else{
    %>
    <h1>No Bookings Available</h1>
    <%} %>
        
    </div>
</body>
</html>
