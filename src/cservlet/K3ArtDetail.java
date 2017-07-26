package cservlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import cdao.ArtDAO;
import cdao.CommentDAO;
import cmodel.Art;
import cmodel.ImageOperation;

/**
 * Servlet implementation class K3ArtDetail
 */
@WebServlet("/K3ArtDetail")
public class K3ArtDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public K3ArtDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int artid=Integer.parseInt(request.getParameter("art_id"));
		//int artid=1;
		//写真詳細　取得
		ArtDAO ad=new ArtDAO();
		Art art=ad.getArtDetail(artid);

		
		//コメント取得
		CommentDAO cd=new CommentDAO();
		ArrayList<String> list=cd.getCommentList(artid);//取得確認
		
		HttpSession session = request.getSession();
		session.setAttribute("art", art);
		session.setAttribute("commentlist",list);
		RequestDispatcher dp=request.getRequestDispatcher("/WEB-INF/jsp/K3-submissiondetail.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
//	
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
//	public ArrayList<String> getCommentList(int artid){
//		ArrayList<String> list=new ArrayList<>();
//		
//		try{
//			connection();
//			String sql = "SELECT comment from comment where art_id=? Order By comment_id ASC";
//
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, artid);
//			rs = stmt.executeQuery();
//
//			while(rs.next()){
//
//				list.add(rs.getString("comment"));
//				
//	
//			}
//		}catch(Exception e){
//			System.out.println(e);
//		}finally{
//			try{
//				close();
//			}catch(Exception e){
//				System.out.println(e);
//			}
//		}
//		for(String s:list){
//			System.out.println(s);
//		}
//		
//		
//		
//		
//		return list;
//	}
//	
//	public Art getArtDetail(int artid){
//		Art art=new Art();
//		
//		try{
//			connection();
//			String sql = "SELECT art.extension,art.art_id,art.art_title ,art.contest_id, art.art_img_name FROM art  WHERE art.art_id = ? ";
//
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, artid);
//			rs = stmt.executeQuery();
//			ImageOperation io=new ImageOperation();
//
//			if(rs.next()){
//				art.setArt_id(rs.getInt("art.art_id"));
//				art.setContest_id(rs.getInt("art.contest_id"));
//				art.setTitle(rs.getString("art.art_title"));
//				art.setBase64Image(io.convertBlobToBase64(rs.getBinaryStream("art_img_name"), rs.getString("art.extension")));	
//			}
//		}catch(Exception e){
//			System.out.println(e);
//		}finally{
//			try{
//				close();
//			}catch(Exception e){
//				System.out.println(e);
//			}
//		}
//		
//
//		return art;
//	}
//

}
