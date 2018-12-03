<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<h1>Login Page.</h1>
	<form action="" method="GET">
		Username: <input type="text" name="userName">		
		Password: <input type="text" name="password">
		<input type="submit" name="Login">

		<%
		String x = request.getParameter("Login");
		if (x != null && x.equals("Submit")) {  
		    String userName = request.getParameter("userName");
		    session.setAttribute("userName", userName);
		    String password = request.getParameter("password");
		    session.setAttribute("password",password);

		    if (userName != null && password != null) {
		    	request.getRequestDispatcher("/ABC/registration").forward(request, response);
			}
		} 
      %>

	</form>
</body>
</html>