<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="repositories.UserList" %>
<%@ page import="repositories.UserInformationRepository" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
    
<%
	UserInformationRepository repo = new UserList();
	if (repo.getUserByUsername("admin") == null)
		repo.addUserToList(repo.createAdmin());
%>
<!DOCTYPE html>
<html lang="pl">
<h1 style="background-color:green">
Skorzystaj z  systemu autoryzacji
</h1>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>System Autoryzacji</title>
		
		 <link href="./styles.css" rel="stylesheet">
		 <link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	</head>
	<body>
		
		<a href="./register.jsp">Strona rejestracji</a><br><br>
		<a href="./login.jsp">Strona logowania</a>
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    <script src="./validate.js"></script>
	</body>
</html>