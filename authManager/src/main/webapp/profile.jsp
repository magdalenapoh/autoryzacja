<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.UserInformation" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpServlet" %>

<%	
	UserInformation user = (UserInformation) session.getAttribute("userLogged");
	String permission = user.getPermission();
	String logged = user.getUsername();
%>
<!DOCTYPE html>
<html lang="pl">
<h1 style="background-color:green">
Logowanie
</h1>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>System Autoryzacji</title>
		
		 <link href="./styles.css" rel="stylesheet">
		 <link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	</head>
<body>
<h1>Witaj <%= logged %> na swoim profilu</h1>
<p>Posiadasz uprawnienia: <%= permission %> </p>
<form action="premium" method="POST">
	<button type="submit">Przejdź do strony premium</button>
</form>
<a href="./index.jsp">Strona Główna</a>
</body>
</html>