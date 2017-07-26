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
import cdao.CommentDAO;
import cmodel.Art;
import cmodel.Comment;
/**
 * Servlet implementation class V2ArtDetail
 */
@WebServlet("/V2ArtDetail")
public class V2ArtDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2ArtDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		Art art = new Art();


		ArtDAO artDAO = new ArtDAO();
		CommentDAO commentDAO = new CommentDAO();
		ArrayList<Comment> list = new ArrayList<Comment>();


//		String id = request.getParameter("art_id");
	//	int art_id = Integer.parseInt(id);

		int art_id = Integer.parseInt(request.getParameter("art_id"));

	//	art = artDAO.selectArtdetail(art_id);
		///////////////テスト用に固定値を使用/////////

		art = artDAO.selectImageById(art_id);
		list = commentDAO.selectComment(art_id);


		if(list.size() == 0){
			session.setAttribute("message", "コメントはありません");
		}

		session.setAttribute("image", art);
		session.setAttribute("artId", art_id);
		System.out.println("セッションに格納するアートID "+art_id);
		session.setAttribute("commentList", list);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/V2-artdetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



