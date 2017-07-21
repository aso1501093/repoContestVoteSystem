package cdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import cmodel.Contest;

public class ContestDAO {
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

	public Contest selectContestName(int contest_id){

		try{
			connection();

			String sql = "SELECT contest_name FROM contest WHERE contest_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,  contest_id);
			rs = stmt.executeQuery();

			rs.next();

			Contest contest = new Contest();

			contest.setName(rs.getString("contest_name"));

			return contest;

		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println(e);
			}
		}

		return null;
	}
}