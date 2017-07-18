package cservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdao.ArtDAO;
import cmodel.Art;

/**
 * Servlet implementation class V2ArtDetail
 */
@WebServlet("/V2ArtDetail")
public class V2ArtDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();

		Art art = new Art();
		ArtDAO artDAO = new ArtDAO();

		String id = request.getParameter("art_id");
		int art_id = Integer.parseInt(id);

		art = artDAO.selectArtdetail(art_id);

		session.setAttribute("artdata", art);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/V2-artdetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
}
