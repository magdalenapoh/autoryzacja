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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.UserInformation;

@WebFilter({"/register.jsp", "/login.jsp"})
public class UserFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		UserInformation user = (UserInformation) session.getAttribute("userLogged");
		
		if (user != null) {
			if (user.getPermission().equals("regular") || user.getPermission().equals("premium")) {
				httpResponse.sendRedirect("profile.jsp");
			}
			if (user.getPermission().equals("admin")) {
				httpResponse.sendRedirect("adminPanel.jsp");
			}
		}		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
