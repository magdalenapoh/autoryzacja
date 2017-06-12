<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
<h1 style="background-color:green">
Logowanie do systemu 
</h1>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>System Autoryzacji</title>
		
		 <link href="./styles.css" rel="stylesheet">
		 <link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<h1>Zaloguj się</h1>
		<form action="login" method="POST">
			<div>
				<label>Nazwa użytkownika</label><br>
				<input id="login" name="login" type="text" required>
			</div>
			<div>
				<label>Hasło</label><br>
				<input id="loginPass" name="loginPass" type="text" required>
			</div>
			<input id="submit" name="loginSubmit" type="submit" value="Zaloguj">	
		</form>
		<a href="./index.jsp">Strona główna</a><br><br>
		<a href="./register.jsp">Strona rejestracji</a>
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    <script src="./validate.js"></script>
	</body>
</html>