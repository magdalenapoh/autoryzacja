package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.UserInformationRepository;
import repositories.UserList;

@WebServlet("/admin")
public class ShowUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInformationRepository repo = new UserList();
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().println(
				"<!DOCTYPE html><html lang='pl'><head><meta charset='utf-8' />"
				+ "<link href='./styles.css' rel='stylesheet'>"
				+ "<link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>"
				+ "</head><body><h1>Dane u¿ytkowników</h1>"
				+ "<table><tr><td>Nazwa</td><td>Has³o</td><td>Email</td><td>Uprawnienia</td></tr>"
				);
		
		for (int i = 0; i < repo.getListSize(); i++) {
			response.getWriter().println(
					"<tr><td>" + repo.getUserInfo(i).getUsername() + "</td>"
					+ "<td>" + repo.getUserInfo(i).getPassword() + "</td>"
					+ "<td>" + repo.getUserInfo(i).getEmail() + "</td>"
					+ "<td>" + repo.getUserInfo(i).getPermission() + "</td></tr>"
					);
		}
		response.getWriter().println(
				"</table>"
				+ "<a href='./adminPanel.jsp'>Powrót</a>"
				+ "</body></html>"
				);
	}

}
