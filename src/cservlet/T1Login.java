package cservlet;
/**
 * Servlet implementation class T1Login
 * name:情シ専3A_石橋英作
 * date:2017/7/10
 * comm:トップに行くための処理
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdao.UserDAO;
import cmodel.User;

@WebServlet("/T1Login")
public class T1Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T1Login() {
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
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		int id = Integer.parseInt(request.getParameter("id"));
		String pass = request.getParameter("pass");
		User user = new User();
		UserDAO userDao = new UserDAO();
		//DB
		user = userDao.loginCheck(id, pass);
		if(user != null){
			session.setAttribute("user", user);
			rd = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
			rd.forward(request, response);
		}else if(user == null){
			String error = "ID,パスワードが違います！";
			session.setAttribute("error", error);
			rd = request.getRequestDispatcher("L1-login.jsp");
			rd.forward(request, response);
		}		
	}

}
