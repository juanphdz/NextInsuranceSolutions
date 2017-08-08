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

import nis.Customers;
import nis.DBUtils;
import nis.Employees;
import nis.MyUtils;

/**
 * Servlet implementation class DoPolicySearchServlet
 */
@WebServlet(urlPatterns = {"/doPolicySearch"})
public class DoPolicySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoPolicySearchServlet() {
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
		Customers customer = new Customers();
		
		String findPolicy = (String) request.getParameter("findPolicy");
		String errorString = null;
		List<Customers> list = null;
		
		if(findPolicy.equals("")){
			errorString = "Policy number or last name is required.";
		}
		if(errorString == null){
			try{
				list = DBUtils.findCustomers(conn, findPolicy);
			} catch(SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
		
		if(list == null){
			errorString = "No results found.";
		}
		
		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("customerList", list);
		
		// If error, forward to Edit page.
		if(errorString != null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/mainView.jsp");
			dispatcher.forward(request, response);
		}
		
		// If everything is a ok.
		// Redirect to customerList.
		else{
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/searchResultsView.jsp");
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
