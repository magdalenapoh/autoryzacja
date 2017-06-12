<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
<h1 style="background-color:green">
Rejestracja 
</h1>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>System Autoryzacji</title>
		
		 <link href="./styles.css" rel="stylesheet">
		 <link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<h1>Wypełnij formularz aby się zarejestrować</h1>
		<form action="register" method="POST">
			<div>
				<label>Nazwa użytkownika</label><br>
				<input id="username" name="username" type="text" required>
			</div>
			<div>
				<label>Hasło</label><br>
				<input id="pass1" name="pass1" type="text" required>
			</div>
			<div>
				<label>Powtorz hasło</label><br>
				<input id="pass2" name="pass2" type="text" required>
			</div>
			<div>
				<label>E-mail</label><br>
				<input id="email" name="email" type="email" required>
			</div>
			<input id="submit" name="registerSubmit" type="submit" value="Zarejestruj">
		</form>
		<a href="./login.jsp">Strona logowania</a><br><br>
		<a href="./index.jsp">Strona główna</a>		
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    <script src="./validate.js"></script>
	</body>
</html>