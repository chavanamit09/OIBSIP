<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="reservation_system_.Details"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<html>
<head>
<style type="text/css">
    .container {
        text-align: center;
    }

    h1 {
        color: gray;
    }

    table {
        margin: auto;
        border-collapse: collapse;
        width: 80%; 
        padding: 10px; 
    }

    th, td {
        border: 2px solid orange;
        padding: 8px; 
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

    <div class="container">
        <h1>Booking History</h1>

        <% 	
        if(l.size()>0){
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
            <% for(Details d:l){ %>
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
            <% } %>
        </table>
        <% }
        else { %>
        <h1>No History Available</h1>
        <% } %>
    </div>
</body>
</html>
