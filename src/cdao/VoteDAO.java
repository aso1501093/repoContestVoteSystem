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
		 try{
	            connection();

	            String sql = "INSERT INTO comment(user_id,contest_id,art_id) VALUES(?.?.?) ";
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, v.getUser_id());
	            stmt.setInt(2, v.getContest_id());
	            stmt.setInt(3, v.getArt_id());


	            stmt.executeUpdate();

	            System.out.println(sql);

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




