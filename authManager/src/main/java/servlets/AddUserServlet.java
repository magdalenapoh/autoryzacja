package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserInformation;
import repositories.UserInformationRepository;
import repositories.UserList;

@WebServlet("/register")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserInformation retrieveUserInfo(HttpServletRequest request)
			throws ServletException, IOException {
		UserInformation result = new UserInformation();
		
		result.setUsername(request.getParameter("username"));
		result.setPassword(request.getParameter("pass2"));
		result.setEmail(request.getParameter("email"));
		result.setPermission("regular");
		return result;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(
				"<!DOCTYPE html><html lang='pl'><head><meta charset='utf-8' />"
				+ "<link href='./styles.css' rel='stylesheet' />"
				+ "<link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css' />"
				+ "</head><body>"
				);
		
		UserInformation user = retrieveUserInfo(request);
		UserInformationRepository repo = new UserList();
		
		if (repo.getUserByUsername(user.getUsername()) != null) {
			response.getWriter().println(
					"<h1>Uzytkownik o podanej nazwie juz istnieje, podaj inne...</h1>"
					);
		} else if (!request.getParameter("pass1").equals(request.getParameter("pass2"))) {
			response.getWriter().println(
					"<h1>Podane hasla rozni sie, sprobuj ponownie...</h1>"
					);
		} else {
			repo.addUserToList(user);
			response.getWriter().println(
					"<h1>Rejestracja przebiegla pomyslnie!</h1>"
					);
		}
		response.getWriter().println(
				"<a href='./register.jsp'>Powrot</a><br><br>"
				+ "<a href='./index.jsp'>Strona glowna</a>"
				+ "</body></html>"
				); 
	}

}
