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
import cmodel.User;
import cmodel.Vote;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/V2Vote")
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
//		HttpSession session = request.getSession();
//
//		User user = (User) session.getAttribute("user");
//		int contestId = (int) session.getAttribute("contestId");
//		int artId = (int) session.getAttribute("artId");
//		System.out.println("セッションから取得したアートID"+artId);
//
//		Vote v = new Vote();
//
//
//		int userId = 1501155;
//
//
//
//		//modelにセット
//		v.setArt_id(artId);
//		System.out.println("モデルにセットしたアートID"+v.getArt_id());
//		v.setContest_id(contestId);
//		v.setUser_id(user.getUser_id());
//		v.setUser_id(userId);
//		//投票実行
//		VoteDAO voteDAO = new VoteDAO();
//		voteDAO.Vote(v);
//
//
//
//		RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/jsp/V2-artdetail.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		int contestId = (int) session.getAttribute("contestId");
		int artId = (int) session.getAttribute("artId");
		System.out.println("セッションから取得したアートID"+artId);

		Vote v = new Vote();





		//modelにセット
		v.setArt_id(artId);
		System.out.println("モデルにセットしたアートID"+v.getArt_id());
		v.setContest_id(contestId);
		v.setUser_id(user.getUser_id());

		//投票実行
		VoteDAO voteDAO = new VoteDAO();
		boolean insert=voteDAO.Vote(v);

		if(insert==true){

		session.setAttribute("votemessage"," 投票完了！");
		}else{

		session.setAttribute("votemessage", "投票失敗!");
		}


		RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/jsp/V2-artdetail.jsp");
		rd.forward(request, response);
	}

}
