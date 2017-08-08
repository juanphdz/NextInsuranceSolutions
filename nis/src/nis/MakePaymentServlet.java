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

/**
 * Servlet implementation class MakePaymentServlet
 */
@WebServlet(urlPatterns = {"/makePayment"})
public class MakePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakePaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		Customers customer = null;
		String errorString = null;
		try{
			customer = DBUtils.findCustomer(conn, policyNumber);
		} catch(SQLException e){
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		// If customer does not exist or an error occurs.
		// Redirect to customer list for now.
		if(errorString != null && customer == null){
			response.sendRedirect(request.getServletPath() + "/customerProfile?policyNumber=" + policyNumber);
			return;
		}
		
		// Store errorString n request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("customer", customer);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/makePaymentView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
