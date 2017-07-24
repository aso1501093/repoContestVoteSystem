package cdao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import cmodel.Art;
import cmodel.ImageOperation;

public class ArtDAO {

	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

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

	//作品一件取得
	public Art selectImageById(int art_id){

		try{
			connection();

			String sql = "SELECT * FROM art WHERE art_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, art_id);
			rs = stmt.executeQuery();

			if(rs.next()){

				Art art = new Art();
				ImageOperation io = new ImageOperation();

				InputStream is = rs.getBinaryStream("art_img_name");
				String extension = art.getExtension();

				art.setTitle(rs.getString("art_title"));
				art.setBase64Image(io.convertBlobToBase64(is, extension));

				return art;
			}

		}catch(Exception e){
			System.out.println("databaseerror "+e);;
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println("2databaseerror "+e);;
			}
		}
		return null;
	}

	//作品リスト取得
	public ArrayList<Art> selectImageByIdList(int contest_id){

		ArrayList<Art> list = new ArrayList<Art>();

		try{
			connection();

			String sql = "SELECT * FROM art, contest"
					+ " WHERE art.contest_id = contest.contest_id AND contest.contest_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, contest_id);
			rs = stmt.executeQuery();

			while(rs.next()){

				Art art = new Art();
				ImageOperation io = new ImageOperation();

				InputStream is = rs.getBinaryStream("art_img_name");
				String extension = art.getExtension();

				art.setArt_id(rs.getInt("art_id"));
				art.setTitle(rs.getString("art_title"));
				art.setBase64Image(io.convertBlobToBase64(is, extension));

				list.add(art);
			}

		}catch(Exception e){
			System.out.println("databaseerror "+e);;
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println("2databaseerror "+e);;
			}
		}
		return list;
	}
}