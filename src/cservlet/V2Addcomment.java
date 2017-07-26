package cservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import cdao.CommentDAO;
import cmodel.Comment;
import cmodel.User;


/**
 * Servlet implementation class V2Addcomment
 */
@WebServlet("/V2Addcomment")
public class V2Addcomment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
    /**
     * Default constructor.
     */
    public V2Addcomment() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
////		System.out.println("test1");
////
////
//		HttpSession session = request.getSession();
//		CommentDAO commentDAO = new CommentDAO();
//		Comment c = new Comment();
////
////		//ユーザ情報と表示中作品情報取得
////		User user = (User)session.getAttribute("user");
//		int artId = (int) session.getAttribute("artId");
//
//
////		//コメント取得+modelへのセット
//		String comment = request.getParameter("comment");
////
//		c.setComment(comment);
//		c.setArt_id(artId);
////		c.setUser_id(user.getUser_id());
//		c.setUser_id(1501155);
//
//		//コメントの投稿
//		commentDAO.insertComment(c);
//
//		//最新のコメント一覧取得
//		ArrayList<Comment> list = new ArrayList<Comment>();
//		list =commentDAO.selectComment(artId);
//		session.setAttribute("commentList", list);
//
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
//		System.out.println("test1");
//
//
		HttpSession session = request.getSession();
		CommentDAO commentDAO = new CommentDAO();
		Comment c = new Comment();
//
//		//ユーザ情報と表示中作品情報取得
		User user  = (User) session.getAttribute("user");
		int artId = (int) session.getAttribute("artId");


//		//コメント取得+modelへのセット
		String comment = request.getParameter("comment");
//
		c.setComment(comment);
		c.setArt_id(artId);
		c.setUser_id(user.getUser_id());
//		c.setUser_id(1501155);
		System.out.println("アートID"+artId);

		//コメントの投稿
		commentDAO.insertComment(c);

		//最新のコメント一覧取得
		ArrayList<Comment> list = new ArrayList<Comment>();
		list =commentDAO.selectComment(artId);
		session.setAttribute("commentList", list);




		RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/jsp/V2-artdetail.jsp");
		rd.forward(request, response);
	}



}


