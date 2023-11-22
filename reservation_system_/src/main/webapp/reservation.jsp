<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            color: gray;
        }
        
        .centered-form {
        	color: fuchsia;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 50vh;
        }
        .form-content {
            text-align: left;
            width: 600px; 
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
        <a href="#">Book Ticket</a>
         <a href="cancel.jsp">Cancel Ticket</a>
         <a href="history.jsp">My Bookings</a>
        
        <div class="user-id"><%=s %></div>
    </div>

    <div class="container"></div>
        <h1 align="center">Online Reservation System</h1>

<div class="centered-form">
    <div class="form-content">
        <form action="reserve1" method="post">
            Name:
            <input type="text" placeholder="Enter name" name="name" required><br><br>
            Age:
            <input type="number" name="age" min="0" required><br><br>
            <label for="gender">Gender:</label> 
            <select id="gender" name="gender" required>
                <option value="select">Select Gender</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select><br><br>
            <label for="trainNumber">Train Number:</label>
            <input type="text" id="trainNumber" name="trainNumber" onkeyup="fetchTrainName()" required>
            <input type="text" id="trainName" name="trainName" readonly><br><br>
            From:
            <input type="text" name="from" placeholder="From place" required>
            To:
            <input type="text" name="to" placeholder="Destination Place" required><br><br>
            Class Type:
            <select id="class" name="class" required>
                <option value="select">Select Class Type</option>
                <option value="Sl">SL</option>
                <option value="2S">2S</option>
                <option value="2A">2A</option>
                <option value="1A">1A</option>
            </select><br><br>
           Date:
			<input type="date" name="date" required min="<?= date('Y-m-d') ?>"><br><br>
            <input type="submit" value="submit">
            <input type="reset" value="reset">
        </form>
    </div>
</div>
 
    <script>
        function fetchTrainName() {
        	
            var trainNumber = document.getElementById("trainNumber").value;
            
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "TrainInfoServlet?trainNumber=" + trainNumber, true);

            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var trainName = xhr.responseText;
                    document.getElementById("trainName").value = trainName;
                }
            };

            xhr.send();
        }
    </script>
</body>
</html>
