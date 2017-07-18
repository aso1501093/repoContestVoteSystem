package cdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import cmodel.Art;

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

	//作品一覧取得
	public ArrayList<Art> selectArtList(int contest_id){

		ArrayList<Art> list = new ArrayList<Art>();

		try{

			connection();

			String sql = "SELECT a.art_title, a.art_img_name FROM art a"
					+ " WHERE a.contest_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, contest_id);
			rs = stmt.executeQuery();

			while(rs.next()){

				Art art = new Art();

				art.setTitle(rs.getString("title"));
				art.setImg(rs.getBlob("img"));

				list.add(art);
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

		return list;
	}

	public Art selectArtdetail(int art_id){

		Art art = new Art();

		try{
			connection();

			String sql= " SELECT a.art_name, a.art_img_name, c.comment"
					+ " FROM art a, comment c"
					+ " WHERE a.art_list = c.art_list AND a.art_id=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, art_id);
			rs = stmt.executeQuery();

			rs.next();

			art.setImg(rs.getBlob("img"));
			//art.set

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