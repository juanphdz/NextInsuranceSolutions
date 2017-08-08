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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class DoMakePaymentServlet
 */
@WebServlet(urlPatterns={"/doMakePayment"})
public class DoMakePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoMakePaymentServlet() {
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
		String sfid = (String) request.getParameter("fid");
		double fid = Double.parseDouble(sfid);
		String stotalAmount = (String) request.getParameter("totalAmount");
		double totalAmount = Double.parseDouble(stotalAmount);
		double brokerFee = totalAmount - fid;
		String paymentType = (String) request.getParameter("paymentType");
		String transactionType = (String) request.getParameter("transactionType");
		String paymentStatus = "Pending";
		String agent = (String) request.getParameter("agent");
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String paymentDate = now.format(formatter);
		 
		
		Customers profile  = new Customers();
		Payments payment = new  Payments(policyNumber, fid, brokerFee, totalAmount, paymentDate, paymentType, transactionType, paymentStatus, agent);
		
		String errorString = null; 
		
		if(policyNumber.equals("") || totalAmount == 0 || agent.equals("") ||  paymentDate.equals("")){
			//errorString = "Total payment cannot be empty.";
			errorString = stotalAmount + " " + policyNumber + " " + agent + " " + paymentDate;
		}

		if(errorString == null){
			try{
				profile = DBUtils.findCustomer(conn, policyNumber);
				DBUtils.makePayment(conn, payment);
			} catch(SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
		
		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("profile", profile);
		request.setAttribute("payment", payment);
		request.setAttribute("loggedInUser", loggedInUser);
		
		// If error, forward to Edit page.
		if(errorString != null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/makePaymentView.jsp");
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
