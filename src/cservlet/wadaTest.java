package cservlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import cmodel.User;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;


/**
 * Servlet implementation class wadaTest
 */
@WebServlet("/wadaTest")
public class wadaTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wadaTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 画像のIDを取得する
					String id = request.getParameter("id");
					
					// 取得したIDに紐づく画像データをDBから取得する
					BufferedImage img = selectImageById(Integer.parseInt(id));
					
					// 画像をクライアントに返却する
					response.setContentType("image/jpeg");
					OutputStream os = response.getOutputStream();
					ImageIO.write(img, "jpg", os);
					os.flush();
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
	}
	
	public BufferedImage selectImageById(int id){


		try{
			connection();

			String sql = "SELECT * FROM art "
					+ "WHERE art_id=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			
			if(rs.next()){
					InputStream is = rs.getBinaryStream("art_img_name");
					BufferedInputStream bis = new BufferedInputStream(is);
					return ImageIO.read(bis);
			}

		}catch(Exception e){
			System.out.println("databaseerror"+e);;
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println("2databaseerror"+e);;
			}
		}
		return null;

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

}
