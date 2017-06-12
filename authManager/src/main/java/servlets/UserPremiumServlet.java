package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/premium")
public class UserPremiumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(
				"<!DOCTYPE html><html lang='pl'><head><meta charset='utf-8' />"
				+ "<link href='./styles.css' rel='stylesheet' />"
				+ "<link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css' />"
				+ "</head><body><h1>Witaj na stronie premium</h1>"
				+ "<a href='./index.jsp'>Strona G³ówna</a><br><br>"
				+ "<a href='./profile.jsp'>Powrót do profilu</a>"
				+ "</body></html>"
				);
	}

}
