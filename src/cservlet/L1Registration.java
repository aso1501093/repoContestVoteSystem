package cservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdao.UserDAO;

/**
 * Servlet implementation class L1Registration
 */
@WebServlet("/L1Registration")
public class L1Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public L1Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		System.out.println("In L1Registration");
		HttpSession session = request.getSession();
		String btn = request.getParameter("btn");
		String message;
		if(btn.equals("registration")){
			int id = Integer.parseInt(request.getParameter("id"));
			String pass = request.getParameter("pass");
			UserDAO userDao = new UserDAO();
			Boolean registration = userDao.registrationUser(id, pass);
			if(registration){
				message = "登録できました！";
				session.setAttribute("registrationMessage", message);
			}else{
				message = "登録できませんでした！";
				session.setAttribute("registrationMessage", message);
			}
		}
			rd = request.getRequestDispatcher("L1-login.jsp");
			rd.forward(request, response);
	}

}
