package cservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdao.VoteDAO;
import cmodel.Vote;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/Vote")
public class V2Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2Vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();

//		User user = (User) session.getAttribute("user");
//		int contestId = (int) session.getAttribute("contestId");
//		int artId = (int) session.getAttribute("artId");

		Vote v = new Vote();


		int userId = 1501155;
		int artId = 1;
		int contestId =1;
		//modelにセット
		v.setArt_id(artId);
		v.setContest_id(contestId);
//		v.setUser_id(user.getUser_id());
		v.setUser_id(userId);
		//投票実行
		VoteDAO voteDAO = new VoteDAO();
		voteDAO.Vote(v);



		RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/jsp/V2-artdetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();

//		User user = (User) session.getAttribute("user");
//		int contestId = (int) session.getAttribute("contestId");
//		int artId = (int) session.getAttribute("artId");

		Vote v = new Vote();


		int userId = 1501155;
		int artId = 1;
		int contestId =1;
		//modelにセット
		v.setArt_id(artId);
		v.setContest_id(contestId);
//		v.setUser_id(user.getUser_id());
		v.setUser_id(userId);
		//投票実行
		VoteDAO voteDAO = new VoteDAO();
		voteDAO.Vote(v);



		RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/jsp/V2-artdetail.jsp");
		rd.forward(request, response);

	}

}
