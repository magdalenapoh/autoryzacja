package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.UserInformation;

@WebFilter("/adminPanel.jsp")
public class AdminFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		UserInformation admin = (UserInformation) session.getAttribute("userLogged");
		
		response.setContentType("text/html; charset=UTF-8");
		
		if (!admin.getPermission().equals("admin")) {
			response.getWriter().println(
					"<!DOCTYPE html><html lang='pl'><head><meta charset='utf-8' />"
					+ "<link href='./styles.css' rel='stylesheet' />"
					+ "<link href='https://fonts.googleapis.com/css?family=Lato:400,300,300italic,700,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css' />"
					+ "</head><body><h1>Nie posiadasz odpowiednich uprawnie�!</h1>"
					+ "<a href='./index.jsp'>Strona G��wna</a><br><br>"
					+ "<a href='./profile.jsp'>Powr�t do profilu</a>"
					+ "</body></html>"
					);
			return;
		}		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
