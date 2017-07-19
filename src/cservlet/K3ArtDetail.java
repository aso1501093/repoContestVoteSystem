package cservlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
		//int artid=(int)request.getAttribute("art_id");
		int artid=1;
		//写真詳細　取得

		
		//コメント取得
		ArrayList<String> list=getCommentList(1);//取得確認
		
		request.setAttribute("commentlist", list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public Connection connection() throws Exception {
		if(ds == null){
			ds = (DataSource)(new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
		}
		con = ds.getConnection();

		return con;
		//Class.forName("com.mysql.jdbc.Driver");
		//con = DriverManager.getConnection(
		//		"jdbc:mysql://localhost:8890/ContestVote", "root", "root");
		//return con;
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
	
	public ArrayList<String> getCommentList(int artid){
		ArrayList<String> list=new ArrayList<>();
		
		try{
			connection();
			String sql = "SELECT comment from comment where art_id=? Order By comment_id ASC";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, artid);
			rs = stmt.executeQuery();

			while(rs.next()){

				list.add(rs.getString("comment"));
				
	
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		for(String s:list){
			System.out.println(s);
		}
		
		
		
		
		return list;
	}


}
