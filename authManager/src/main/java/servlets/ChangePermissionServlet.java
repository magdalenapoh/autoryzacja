package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.UserInformationRepository;
import repositories.UserList;

@WebServlet("/permission")
public class ChangePermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		UserInformationRepository repo = new UserList();
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(
				"<!DOCTYPE html><html lang='pl'><head><meta charset='utf-8' />"
				+ "<link href='./styles.css' rel='stylesheet'>"
				+ "<link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>"
				+ "</head><body>"
				);
		
		String username = request.getParameter("username");		
		String permission = request.getParameter("perms");
		
		if (repo.getUserByUsername(username) != null &&
			!repo.getUserByUsername(username).getPermission().equals("admin")) {
			repo.getUserByUsername(username).setPermission(permission);
			
			response.getWriter().println(
					"<h1>Uprawnienia zosta³y zmienione pomyœlnie!</h1>"
					);
		} else {
			response.getWriter().println(
					"<h1>Podana nazwa u¿ytkownika jest niepoprawna lub u¿ytkownik nie istnieje, spróbuj ponownie...</h1>"
					);
		}
		response.getWriter().println(
				"<a href='./adminPanel.jsp'>Powrót</a>"
				+ "</body></html>"
				);
	}

}
