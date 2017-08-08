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
 * Servlet implementation class DoBankingServlet
 */
@WebServlet(urlPatterns={"/doBanking"})
public class DoBankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoBankingServlet() {
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
		Banking banking = new Banking();
		
		String sstartDate = (String) request.getParameter("startDate");
		String startDate = sstartDate + " 00:00:00";
		String sendDate = (String) request.getParameter("endDate");
		String endDate = sendDate + " 23:59:59";
		String errorString = null;
		List<Banking> list = null;
		
		if(sstartDate.equals("") || sendDate.equals("")){
			errorString = "You must provide a start date and end date.";
		}
		if(errorString == null){
			try{
				list = DBUtils.getBanking(conn, startDate, endDate);
			} catch(SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
		
		if(list == null){
			errorString = "No results found within search range.";
		}
		
		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("bankingList", list);
		
		// If error, forward to Edit page.
		if(errorString != null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/bankingSearchView.jsp");
			dispatcher.forward(request, response);
		}
		
		// If everything is a ok.
		// Redirect to customerList.
		else{
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/bankingResultsView.jsp");
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
