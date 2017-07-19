package cservlet;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.util.codec.binary.Base64;

import com.mysql.jdbc.Blob;

import cmodel.User;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
		System.out.println("wadaTest　id-"+id);

		// 取得したIDに紐づく画像データをDBから取得する
		BufferedImage img = selectImageById(1);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);
        img.flush();

        // 読み終わった画像をバイト出力へ。
        ImageIO.write(img, "jpg", bos);
        bos.flush();
        bos.close();
        byte[] bImage = baos.toByteArray();

        // バイト配列→BASE64へ変換する
        Base64 base64 = new Base64();
        byte[] encoded = base64.encode(bImage);
        String base64Image = new String(encoded);
        System.out.println("base64Image  "+base64Image);
        System.out.println("base64Image 長さ"+base64Image.length());

//		// 画像をクライアントに返却する
//							response.setContentType("image/jpeg");
//							//戻り値　レスポンスにバイナリデータを出力する際に使用する ServletOutputStream型のオブジェクトを返す。
//							OutputStream os = response.getOutputStream();
//							
//							
//							ImageIO.write(img, "jpg", os);//osに画像を出力している
//							
//							os.flush();//osをコミットしている

		RequestDispatcher dp=request.getRequestDispatcher("/WEB-INF/jsp/wada.jsp");

		request.setAttribute("test", base64Image);
		dp.forward(request, response);

		//OutputStreamオブジェクトを返している？明日これをresponseで送ってみる.それかbufferedImage ImageIO
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
//		Class.forName("com.mysql.jdbc.Driver");
//		con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:8890/ContestVote", "root", "root");
//		return con;
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
