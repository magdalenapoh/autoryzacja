package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.UserInformationRepository;
import repositories.UserList;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInformationRepository repo = new UserList();
		String header = "<!DOCTYPE html><html lang='pl'><head><meta charset='utf-8' />"
				+ "<link href='./styles.css' rel='stylesheet' />"
				+ "<link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css' />"
				+ "</head><body>";
		
		response.setContentType("text/html; charset=UTF-8");
		
		if (repo.getUserByUsername(request.getParameter("login")) != null) {
			HttpSession session = request.getSession();			
			String pass = repo.getUserByUsername(request.getParameter("login")).getPassword();
			
			if (request.getParameter("loginPass").equals(pass) &&
				repo.getUserByUsername(request.getParameter("login")).getPermission().equals("admin")) {
				session.setAttribute("userLogged", repo.getUserByUsername(request.getParameter("login")));
				response.sendRedirect("adminPanel.jsp");
				
			} else if (request.getParameter("loginPass").equals(pass)) {
				session.setAttribute("userLogged", repo.getUserByUsername(request.getParameter("login")));
				response.sendRedirect("profile.jsp");
			} else {
				response.getWriter().println(
						header
						+ "<h1>Niepoprawne has³o, spróbuj ponownie...</h1>"
						+ "<a href='./login.jsp'>Powrót</a><br><br>"
						+ "<a href='./index.jsp'>Strona G³ówna</a>"
						+ "</body></html>"
						);
			}
		} else {
			response.getWriter().println(
					header
					+ "<h1>Niepoprawny login, sprobuj ponownie...</h1>"
					+ "<a href='./index.jsp'>Strona G³ówna</a>"
					+ "</body></html>"
					);
		}
	}	
}
