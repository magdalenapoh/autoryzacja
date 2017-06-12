<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
<h1 style="background-color:green">
Zarządzanie uprawnieniami</h1>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>System Autoryzacji</title>
		
		 <link href="./styles.css" rel="stylesheet">
		 <link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	</head>
	<body>
		
		<form action="permission" method="POST">
			<label>Nazwa użytkownika</label><br>
			<input id="username" name="username" type="text" required><br>
			<label>Uprawnienia</label><br>
			<input id="regular" type="radio" name="perms" value="regular" checked> Regular<br>
		    <input id="premium" type="radio" name="perms" value="premium"> Premium<br>
		    <button type="submit">Zapisz</button>
		</form>
		<h1>Lista Użytkowników</h1>
		<form action="admin" method="POST">
			<button type="submit">Wyświetl Listę</button>
		</form>
		<a href="./index.jsp">Strona główna</a>
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    <script src="./validate.js"></script>
	</body>
</html>