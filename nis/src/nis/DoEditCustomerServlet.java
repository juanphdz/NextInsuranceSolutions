package nis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import nis.Customers;
import nis.DBUtils;
import nis.MyUtils;

/**
 * Servlet implementation class DoEditCustomerServlet
 */
@WebServlet(urlPatterns = {"/doEditCustomer"})
public class DoEditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEditCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		// Check if user logged in
		Employees loggedInUser = MyUtils.getLoggedInUser(session);
		
		// Not logged in
		if(loggedInUser == null){
			
			// Redirect to login page.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		// Store info in request attribute
		request.setAttribute("user", loggedInUser);
		
		// User is logged in, proceed to connect to DB.
		Connection conn = MyUtils.getStoredConnection(request);
		
		String policyNumber = (String) request.getParameter("policyNumber");
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		
		Customers customer = new Customers();
		
		customer.setPolicyNumber(policyNumber);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		
		String errorString = null;
		
		try{
			DBUtils.updateCustomerName(conn, customer);
		}catch(SQLException e){
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("customer", customer);
		
		// If error occurs, forward to Edit page.
		if(errorString != null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editCustomerView.jsp");
			dispatcher.forward(request, response);
		}
		// If update is completed.
		// Go to customer list, or in the future to single customer page.
		else{ 
			response.sendRedirect(request.getContextPath() + "/customerList");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
