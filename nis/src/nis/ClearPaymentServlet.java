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
 * Servlet implementation class ClearPaymentServlet
 */
@WebServlet(urlPatterns={"/clearPayment"})
public class ClearPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClearPaymentServlet() {
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
		
		String paymentId = (String) request.getParameter("paymentId");

		
		String errorString = null;
		
		try{
			DBUtils.clearPayment(conn, paymentId);
		}catch(SQLException e){
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		// Store information to request attribute, before forward to views.
		
		
		// If error occurs, forward to Edit page.
		if(errorString != null){
			request.setAttribute("errorString", errorString);
			response.sendRedirect(request.getContextPath() + "/pendingPayments");
		}
		// If update is completed.
		// Go to customer list, or in the future to single customer page.
		else{ 
			response.sendRedirect(request.getContextPath() + "/pendingPayments");
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
