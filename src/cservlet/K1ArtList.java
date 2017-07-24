package cservlet;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.util.codec.binary.Base64;

import cdao.ArtDAO;
import cdao.ContestDAO;
import cmodel.Art;
import cmodel.Comment;
import cmodel.Contest;
import cmodel.ImageOperation;

/**
 * Servlet implementation class K1ArtList
 */
@WebServlet("/K1ArtList")
public class K1ArtList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public K1ArtList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		String contestid= request.getParameter("contest_id");
		String contestid="1";
		int i=4;
	//
		ArtDAO ad=new ArtDAO();
		

		ArrayList<Art> artList=ad.getArtList(1);


		//request.setAttribute("contest", contest);とりあえずいらない
		request.setAttribute("artlist", artList);
		//request.setAttribute("art", test(1));

		RequestDispatcher dp=request.getRequestDispatcher("/WEB-INF/jsp/K1-ranking.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
//	public ArrayList<Art> getArtList(int contestid){
//		ArrayList<Art> artlist=new ArrayList<>();
//		try{
//			connection();
//			String sql = "SELECT art.extension,art.art_id,art.art_title ,art.contest_id,count(vote.user_id) as votenum, art.art_img_name FROM art LEFT OUTER JOIN vote ON art.art_id =vote.art_id WHERE art.contest_id = ? GROUP BY art.art_id";
//
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, contestid);
//			rs = stmt.executeQuery();
//
//			while(rs.next()){
//
//				Art art =new Art();
//				art.setArt_id(rs.getInt("art_id"));
//				art.setTitle(rs.getString("art_title"));
//				art.setContest_id(rs.getInt("contest_id"));
//				art.setVote_num(rs.getInt("votenum"));
//				art.setExtension(rs.getString("extension"));
//				InputStream is = rs.getBinaryStream("art_img_name");
//				ImageOperation io=new ImageOperation();
//				//			art.setBase64Image(io.convertBlobToBase64(is,art.getExtension()));
//				art.setBase64Image(io.convertBlobToBase64(is,art.getExtension()));
//				is.close();
//     			artlist.add(art);
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
//		return artlist;
//
//	}


//	public String test(int contestid){
//		String text="---";
//		try{
//			connection();
//			String sql = "SELECT art.extension,art.art_id,art.art_title ,art.contest_id,count(vote.user_id) as votenum, art.art_img_name FROM art LEFT OUTER JOIN vote ON art.art_id =vote.art_id WHERE art.contest_id = ? GROUP BY art.art_id";
//
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, contestid);
//			rs = stmt.executeQuery();
//			if(rs.next()){
//
//				InputStream is = rs.getBinaryStream("art_img_name");
//				BufferedInputStream bis = new BufferedInputStream(is);
//				try {
//					BufferedImage img=ImageIO.read(bis);
//					ByteArrayOutputStream baos = new ByteArrayOutputStream();
//					BufferedOutputStream bos = new BufferedOutputStream(baos);
//					img.flush();
//
//					// 読み終わった画像をバイト出力へ。
//					ImageIO.write(img, "jpg", bos);
//					bos.flush();
//					bos.close();
//					byte[] bImage = baos.toByteArray();
//
//					// バイト配列→BASE64へ変換する
//					Base64 base64 = new Base64();
//					byte[] encoded = base64.encode(bImage);
//					String  base64Image = new String(encoded);
//					String imgText="data:image/jpg;base64,"+base64Image;
//
//					System.out.println("base64Image  "+base64Image);
//					System.out.println("base64Image 長さ"+base64Image.length());
//					text=imgText;
//
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					System.out.println(e);
//					e.printStackTrace();
//
//				}
//				is.close();
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
//
//
//
//		return text;
//
//	}


	
	
	//				BufferedInputStream bis = new BufferedInputStream(is);
	//				try {
	//					BufferedImage img=ImageIO.read(bis);
	//					ByteArrayOutputStream baos = new ByteArrayOutputStream();
	//					BufferedOutputStream bos = new BufferedOutputStream(baos);
	//					img.flush();
	//
	//					// 読み終わった画像をバイト出力へ。
	//					ImageIO.write(img, "jpg", bos);
	//					bos.flush();
	//					bos.close();
	//					byte[] bImage = baos.toByteArray();
	//
	//					// バイト配列→BASE64へ変換する
	//					Base64 base64 = new Base64();
	//					byte[] encoded = base64.encode(bImage);
	//					String  base64Image = new String(encoded);
	//				
	//					String imgText="data:image/jpg;base64,"+base64Image;
	//					System.out.println("base64Image  "+base64Image);
	//					System.out.println("base64Image 長さ"+base64Image.length());
	//					art.setBase64Image(imgText);
	//
	//
	//
	//				} catch (IOException e) {
	//					// TODO Auto-generated catch block
	//					System.out.println(e);
	//					e.printStackTrace();
	//					
	//				}
	//				is.close();
	//				artlist.add(art);

}
