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
 * Servlet implementation class DoAddAdditionalDriverServlet
 */
@WebServlet(urlPatterns={"/doAddAdditionalDriver"})
public class DoAddAdditionalDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAddAdditionalDriverServlet() {
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
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String dateOfBirth = (String) request.getParameter("dateOfBirth");
		String driverLicense = (String) request.getParameter("driverLicense"); 
		String driverStatus = (String) request.getParameter("driverStatus");
		System.out.println(policyNumber);
		
		Customers profile  = new Customers();
		AdditionalDrivers addDriver = new AdditionalDrivers(policyNumber, firstName, lastName, dateOfBirth, driverLicense, driverStatus);
		
		String errorString = null; 
		
		if(policyNumber.equals("") || firstName.equals("") || lastName.equals("")){
			errorString = "First name, and last name cannot be empty.";
		}
		if(errorString == null){
			try{
				profile = DBUtils.findCustomer(conn, policyNumber);
				DBUtils.addAdditionalDriver(conn, addDriver);
			} catch(SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
		
		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("profile", profile);
		request.setAttribute("addDriver", addDriver);
		
		// If error, forward to Edit page.
		if(errorString != null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/addAdditionalDriverView.jsp");
			dispatcher.forward(request, response);
		}
		
		// If everything is a ok.
		// Redirect to customerList.
		else{
			response.sendRedirect(request.getContextPath() + "/customerProfile?policyNumber=" + policyNumber);
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
