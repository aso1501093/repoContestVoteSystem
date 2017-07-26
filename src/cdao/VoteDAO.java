package cdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import cmodel.Vote;

public class VoteDAO {
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


	public void Vote(Vote v){
		int userId = v.getUser_id();
		System.out.println("ユーザーID"+v.getUser_id());
		int artId = v.getArt_id();
		System.out.println("アートID"+v.getArt_id());
		int contestId = v.getContest_id();
		System.out.println("コンテストID"+v.getContest_id());
		 try{
	            connection();

	            String sql = "INSERT INTO vote(user_id,contest_id,art_id) "
	            		+ "VALUES(?,?,?)";
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, userId);
	            stmt.setInt(2, contestId);
	            stmt.setInt(3, artId);

	            stmt.executeUpdate();



	        }catch(Exception e){
	            System.out.println("Inserterror1"+e);
	        }finally{
	            try{
	                close();
	            }catch(Exception e){
	            	System.out.println("Inserterror2"+e);

	            }
	        }
	}

}




