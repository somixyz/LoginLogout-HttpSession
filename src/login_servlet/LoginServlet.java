package login_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 4277980887251651736L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("admin")) {
			out.println("Welcome " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} else {
			out.print("Sorry, wrong username or password !");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();

	}
}
