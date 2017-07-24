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

	public ArrayList<Art> getArtList(int contestid){//過去の作品一覧で使用 //作成者　和田
		ArrayList<Art> artlist=new ArrayList<>();
		try{
			connection();
			String sql = "SELECT art.extension,art.art_id,art.art_title ,art.contest_id,count(vote.user_id) as votenum, art.art_img_name FROM art LEFT OUTER JOIN vote ON art.art_id =vote.art_id WHERE art.contest_id = ? GROUP BY art.art_id";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, contestid);
			rs = stmt.executeQuery();

			while(rs.next()){

				Art art =new Art();
				art.setArt_id(rs.getInt("art_id"));
				art.setTitle(rs.getString("art_title"));
				art.setContest_id(rs.getInt("contest_id"));
				art.setVote_num(rs.getInt("votenum"));
				art.setExtension(rs.getString("extension"));
				InputStream is = rs.getBinaryStream("art_img_name");
				ImageOperation io=new ImageOperation();
				//			art.setBase64Image(io.convertBlobToBase64(is,art.getExtension()));
				art.setBase64Image(io.convertBlobToBase64(is,art.getExtension()));
				is.close();
				artlist.add(art);


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
		return artlist;

	}
	
	public Art getArtDetail(int artid){//過去の作品詳細で使用　作成者　和田
		Art art=new Art();
		
		try{
			connection();
			String sql = "SELECT art.extension,art.art_id,art.art_title ,art.contest_id, art.art_img_name FROM art  WHERE art.art_id = ? ";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, artid);
			rs = stmt.executeQuery();
			ImageOperation io=new ImageOperation();

			if(rs.next()){
				art.setArt_id(rs.getInt("art.art_id"));
				art.setContest_id(rs.getInt("art.contest_id"));
				art.setTitle(rs.getString("art.art_title"));
				art.setBase64Image(io.convertBlobToBase64(rs.getBinaryStream("art_img_name"), rs.getString("art.extension")));	
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
		

		return art;
	}


}