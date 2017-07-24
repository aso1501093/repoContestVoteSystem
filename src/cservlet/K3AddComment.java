package cservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
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
 * Servlet implementation class K3AddComment
 */
@WebServlet("/K3AddComment")
public class K3AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public K3AddComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		String newcomment=request.getParameter("comment");
		
		//テスト用------------------
		User user=new User();
		user.setUser_id(1501155);
		session.setAttribute("user", user);
		//---------------------------
		
		
		User loginuser=(User)session.getAttribute("user");
		
		
		
		int user_id=loginuser.getUser_id();
		int art_id=Integer.parseInt(request.getParameter("art_id"));
		Comment comment=new Comment();
		comment.setArt_id(art_id);
		comment.setComment(newcomment);
		comment.setUser_id(loginuser.getUser_id());

		if(!newcomment.equals("")){//コメント追加
			ArrayList<String> list=(ArrayList<String>) session.getAttribute("commentlist");
			list.add(newcomment);
			session.setAttribute("commentlist", list);
			CommentDAO cd=new CommentDAO();	
			cd.insertComment(comment);
		}


		RequestDispatcher dp=request.getRequestDispatcher("/WEB-INF/jsp/K3-submissiondetail.jsp");
		dp.forward(request, response);

	}


//	public Connection connection() throws Exception {
//		if(ds == null){
//			ds = (DataSource)(new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
//		}
//		con = ds.getConnection();
//
//		return con;
//		//Class.forName("com.mysql.jdbc.Driver");
//		//con = DriverManager.getConnection(
//		//		"jdbc:mysql://localhost:8890/ContestVote", "root", "root");
//		//return con;
//	}
//
//	public void close() throws Exception{
//		if(rs != null){
//			rs.close();
//		}
//		if(stmt != null){
//			stmt.close();
//		}
//		if(con != null){
//			con.close();
//		}
//	}
//
//
//	public boolean addComment(int art_id,int user_id,String comment){
//
//		int autoIncKey=-1;
//		try {
//			// DB接続
//			connection();
//			//INSERT文の設定・実行
//			//INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
//			String sql = "INSERT INTO comment (art_id,user_id,comment)  VALUES(?,?,?);";
//			stmt = con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
//			stmt.setInt(1, art_id);
//			stmt.setInt(2, user_id);
//			stmt.setString(3,comment);
//			stmt.executeUpdate();
//
//
//		} catch (Exception e) {
//			System.out.println(e);
//			return false;
//		}finally {
//			try {
//				close();
//			} catch (Exception e) {
//				System.out.println("insertData clse 失敗");
//			}
//		}
//
//		return true;
//	}
//	
//	

}
