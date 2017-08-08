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

import nis.DBUtils;
import nis.MyUtils;

/**
 * Servlet implementation class DeleteCustomerServlet
 */
@WebServlet(urlPatterns = {"/deleteCustomer"})
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerServlet() {
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
		String errorString = null;
		
		try{
			DBUtils.deleteCustomer(conn, policyNumber);
		}catch(SQLException e){
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		// If an error occurs, redirect to error page.
		if(errorString != null){
			// Store the information in the request attribute before forward
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/deleteCustomerErrorView.jsp");
			dispatcher.forward(request, response);
		}
		
		// If no errors occur.
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
