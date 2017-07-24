package cservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdao.ArtDAO;
import cdao.ContestDAO;
import cmodel.Art;
import cmodel.Contest;

/**
 * Servlet implementation class V1ArtList
 */
@WebServlet("/V1ArtList")
public class V1ArtList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();

		ArtDAO artDAO = new ArtDAO();
		ArrayList<Art> list = new ArrayList<Art>();
		Contest contest = new Contest();
		ContestDAO contestDAO = new ContestDAO();

		//int contest_id = Integer.parseInt(request.getParameter("contest_id"));
		int contest_id = 1;
		int user_id = 1501155;

		list = artDAO.selectImageByIdList(contest_id);
		contest = contestDAO.selectContestName(contest_id);


		session.setAttribute("contestName", contest);
		session.setAttribute("artList", list);
		session.setAttribute("contestId", contest_id);
		session.setAttribute("userId", user_id);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/V1-artlist.jsp");
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