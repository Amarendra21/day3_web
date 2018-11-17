package pages_rd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.User;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("From 1st page....<br>");
//			pw.flush();
			// create user pojo from req params & add it in suitable scope
			// --server pull
			User u = new User(request.getParameter("nm"), Integer.parseInt(request.getParameter("age")),
					Date.valueOf(request.getParameter("hire_date")));
			request.setAttribute("user_dtls",u);
			//RD
			RequestDispatcher rd=request.getRequestDispatcher("s2");
			if(rd != null)
				rd.forward(request, response);
			
		}
	}

}







