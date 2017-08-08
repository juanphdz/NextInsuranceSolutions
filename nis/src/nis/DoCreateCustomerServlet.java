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

import nis.Customers;
import nis.DBUtils;
import nis.MyUtils;

@WebServlet(urlPatterns = {"/doCreateCustomer"})
public class DoCreateCustomerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public DoCreateCustomerServlet(){
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
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
		String errorString = null; 
		String policyNumber = (String) request.getParameter("policyNumber");
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String dateOfBirth = (String) request.getParameter("dateOfBirth");
		if(!dateOfBirth.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")){
			errorString = "Date of Birth must be in YYYY-MM-DD format.";
		}
		String driverLicense = (String) request.getParameter("driverLicense"); 
		String phoneNumber = (String) request.getParameter("phoneNumber");
		String addressStreet = (String) request.getParameter("addressStreet");
		String addressCity = (String) request.getParameter("addressCity");
		String addressState = (String) request.getParameter("addressState");
		String addressZip = (String) request.getParameter("addressZip");
		
		Customers customer  = new Customers(policyNumber, firstName, lastName, dateOfBirth, driverLicense, phoneNumber, addressStreet, addressCity, addressState, addressZip);
		
		
		
		if(policyNumber.equals("") || firstName.equals("") || lastName.equals("")){
			errorString = "Policy number, first name, and last name cannot be empty.";
		}
		if(errorString == null){
			try{
				DBUtils.insertCustomer(conn, customer);
			} catch(SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
		
		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("customer", customer);
		
		// If error, forward to Edit page.
		if(errorString != null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createCustomerView.jsp");
			dispatcher.forward(request, response);
		}
		
		// If everything is a ok.
		// Redirect to customerList.
		else{
			response.sendRedirect(request.getContextPath() + "/customerProfile?policyNumber=" + policyNumber);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doGet(request, response);
	}

}
