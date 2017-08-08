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

import nis.Employees;
import nis.DBUtils;
import nis.MyUtils;

@WebServlet(urlPatterns = {"/doLogin"})
public class DoLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public DoLoginServlet(){
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);
		
		Employees user = null;
		boolean hasError = false;
		String errorString = null;
		
		if(email == null || password == null 
				|| email.length() == 0 || password.length() == 0){
			hasError = true;
			errorString = "Username and password are required.";
		}
		else{
			Connection conn =  MyUtils.getStoredConnection(request);
			try{
				user = DBUtils.findEmployee(conn, email, password);
				
				if(user == null){
					hasError = true;
					errorString = "Login incorrect. Please try again.";
				}
			} catch (SQLException e){
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		
		// If error, forward to /WEB-INF/views/login.jsp
		if(hasError){
			user = new Employees();
			user.setEmail(email);
			user.setPassword(password);
			
			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			
			// Forward to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			dispatcher.forward(request, response);
		}
		else{
			HttpSession session = request.getSession();
			MyUtils.storeLoggedInUser(session, user);
			
			// If user checked "Remember me".
			if(remember){
				MyUtils.storeUserCookie(response, user);
			}
			
			// Else delete cookie.
			else{
				MyUtils.deleteUserCookie(response);
			}
			
			// Redirect to userinfo page
			response.sendRedirect(request.getContextPath() + "/main");
		}
		

	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
