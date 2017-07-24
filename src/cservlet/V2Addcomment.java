package cservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import cmodel.Comment;


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
		RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/jsp/V2-detail.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);


		HttpSession session = request.getSession();
//		CommentDAO commentDAO = new CommentDAO();
		Comment c = new Comment();

		//ユーザ情報と表示中作品情報取得
//		User user = (User)session.getAttribute("user");
//		Art art = (Art) session.getAttribute("artdata");

		//コメント取得+modelへのセット
		String comment = request.getParameter("comment");
		c.setComment(comment);
//		c.setArt_id(art.getArt_id());
//		c.setUser_id(user.getUser_id());
		//コメントの投稿
		//commentDAO.insertComment(c,comment);

		c.setArt_id(1);
		c.setUser_id(1501155);
		insertComment(c,comment);



		RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/jsp/V2-detail.jsp");
		rd.forward(request, response);
	}


	/////////////////////////////insertDAOの処理///////////////////////////////////////////////
	public Connection connection() throws Exception {
		if(ds == null){
			ds = (DataSource)(new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
		}
		con = ds.getConnection();

		return con;
	}
	public void close() throws Exception{
		if(rs != null){
			rs.close();
		}
		if(stmt != null){
			stmt.close();
		}
		if(con != null){
			con.close();
		}
	}
	public void insertComment(Comment c, String comment){

		int art_id = c.getArt_id();
		int user_id = c.getUser_id();

		try{
			connection();

			String sql = "INSERT INTO comment(art_id, user_id, comment)"
					+ "VALUES (?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, art_id);
			stmt.setInt(2, user_id);
			stmt.setString(3, comment);
			stmt.executeUpdate();

		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
	//////////////////////////////////////////////////////////////////////////////////
}


