package nis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerProfileServlet
 */
@WebServlet(urlPatterns = {"/customerProfile"})
public class CustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerProfileServlet() {
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
		Customers profile = new Customers();
		List<AdditionalDrivers> additionalDriver = null;
		List<Vehicles> vehicle = null;
		List<Payments> payment = null;
		String errorString = null;
		
		try{
			profile = DBUtils.findCustomer(conn, policyNumber);
			additionalDriver = DBUtils.getAdditionalDrivers(conn, policyNumber);
			vehicle = DBUtils.getVehicles(conn, policyNumber);
			payment = DBUtils.getPayments(conn, policyNumber);
		}catch(SQLException e){
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("profile", profile);
		request.setAttribute("additionalDriver", additionalDriver);
		request.setAttribute("vehicle", vehicle);
		request.setAttribute("payment", payment);
		
		// If error occurs, forward to Edit page.
		if(errorString != null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/mainView.jsp");
			dispatcher.forward(request, response);
		}
		// If update is completed.
		// Go to customer list, or in the future to single customer page.
		else{
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/customerProfileView.jsp");
			dispatcher.forward(request, response);
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
