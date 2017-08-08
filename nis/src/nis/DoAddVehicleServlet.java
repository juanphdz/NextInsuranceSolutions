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
 * Servlet implementation class DoAddVehicleServlet
 */
@WebServlet(urlPatterns = {"/doAddVehicle"})
public class DoAddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAddVehicleServlet() {
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
		String vehicleYear = (String) request.getParameter("vehicleYear");
		String vehicleMake = (String) request.getParameter("vehicleMake");
		String vehicleModel = (String) request.getParameter("vehicleModel");
		String vehicleVin = (String) request.getParameter("vehicleVin"); 
		
		Customers profile  = new Customers();
		Vehicles vehicle = new  Vehicles(vehicleYear, vehicleMake, vehicleModel, vehicleVin, policyNumber);
		
		String errorString = null; 
		
		if(policyNumber.equals("") || vehicleYear.equals("") || vehicleMake.equals("") ||  vehicleVin.equals("")){
			errorString = "Vehicle year, make, vin or policy number cannot be empty.";
		}
		if(vehicleVin.length() > 17){
			errorString = "Vin must be less than 17 characters.";
		}
		if(errorString == null){
			try{
				profile = DBUtils.findCustomer(conn, policyNumber);
				DBUtils.addVehicle(conn, vehicle);
			} catch(SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
		
		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("profile", profile);
		request.setAttribute("vehicle", vehicle);
		
		// If error, forward to Edit page.
		if(errorString != null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/addVehicleView.jsp");
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
