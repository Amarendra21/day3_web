package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookShopDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class CustomerRegServlet
 */
@WebServlet("/CustomerRegServlet")
public class CustomerRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookShopDaoImpl dao;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			
			Customer c=new Customer(Double.parseDouble(request.getParameter("amt")),request.getParameter("em"), request.getParameter("name"), request.getParameter("pass"), Date.valueOf(request.getParameter("date")),request.getParameter("role"));
			String res = dao.doRegistration(c);
			pw.print(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
