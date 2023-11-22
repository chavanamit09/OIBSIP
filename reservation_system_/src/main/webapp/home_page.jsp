<!DOCTYPE html>
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
            color: silver;
        }
    </style>
</head>
<body>
    <%HttpSession hs=request.getSession();
    String s=(String)hs.getAttribute("id");
    %>
    <div class="navbar">
    	<a href="home_page.jsp">Home</a>
    	<a href="login_page.html"> Go to login</a>
        <a href="reservation.jsp">Book Ticket</a>
        <a href="cancel.jsp">Cancel Ticket</a>
        <a href="history.jsp">My Bookings</a>
        
        <div class="user-id"><%=s %></div>
    </div>

    <div class="container">
        <h1 align="center">Online Reservation System</h1>
    </div>
</body>
</html>
