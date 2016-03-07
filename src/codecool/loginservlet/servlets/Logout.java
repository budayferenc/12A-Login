package codecool.loginservlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		session.invalidate();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='UTF-8'></head>");
		out.println("<title>Logged out</title>");
		out.println("<body bgcolor='#0AD161'>");
		out.println("<p><h1>Byebye, " + username + "!</h1></p>");
		out.println("Please <a href='login.html'><b>log in again</b></a>.</p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}