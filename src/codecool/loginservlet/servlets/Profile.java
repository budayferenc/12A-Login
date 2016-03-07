package codecool.loginservlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String authorizedUsername = "buday";
	private String authorizedPassword = "1234";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");

		if (username == null && password == null) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'></head>");
			out.println("<title>Profile page</title>");
			out.println("<body bgcolor='#0AD161'>");
			out.println("<p><h1>Access denied.</h1></p>");
			out.println(
					"<p>To access this page, you must log in. <br><a href='login.html'><b>Click here to login</b></a>.");
			out.println("</body></html>");
		} else {
			System.out.println("!! - GET");
			out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'></head>");
			out.println("<title>Profile page</title>");
			out.println("<body bgcolor='#0AD161'>");
			out.println("<p><h1>Hey " + username + ", your session is active!</h1></p>");
			out.println("The session is active. Click here to <a href='Logout'><b>logging out</b></a>?</p>");
			out.println("</body></html>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (authorizedUsername.equals(username) && authorizedPassword.equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);

			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Profile page</title>");
			out.println("<body bgcolor='#0AD161'>");
			out.println("<p><h1>" + username + "'s profile</h1></p>");
			out.println("<p>Welcome to your profile <b><i>" + username + "</i></b>!<br>");
			out.println("&nbsp&nbsp&nbsp Your first name: Ferenc<br>");
			out.println("&nbsp&nbsp&nbsp Your last name: Buday<br>");
			out.println("&nbsp&nbsp&nbsp Your username: " + username + "<br>");
			out.println("&nbsp&nbsp&nbsp Your phone number: 00 36 70 368 3303<br><br>");
			out.println("Click here to <a href='Logout'><b>logout</b></a>?</p>");
			out.println("</html>");
		} else {
			String loginUnsuccessful = "loginUnsuccessful.html";
			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", loginUnsuccessful);
		}

	}

}