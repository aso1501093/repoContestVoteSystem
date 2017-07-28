package cdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

	public ArrayList<Contest> getVoteContest(String date){

		ArrayList<Contest> list = new ArrayList<>();
		Contest contest;

		try{
			connection();

			String sql = "SELECT * FROM contest "
					+ "WHERE vote_start_date <= ? AND "
					+ "vote_end_date >= ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, date);
			stmt.setString(2, date);
			rs = stmt.executeQuery();


			while(rs.next()){
				contest = new Contest();
				contest.setContest_id(rs.getInt("contest_id"));
				contest.setName(rs.getString("contest_name"));
				contest.setStart_date(rs.getDate("vote_start_date"));
				contest.setEnd_date(rs.getDate("vote_end_date"));
				list.add(contest);
			}

		}catch(Exception e){
			contest = null;
			System.out.println("databaseerror"+e);
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println("2databaseerror"+e);
			}
		}

		return list;
	}


	public ArrayList<Contest> getPastContest(String date){

		ArrayList<Contest> list = new ArrayList<>();
		Contest contest;

		try{
			connection();

			String sql = "SELECT * FROM contest "
					+ "WHERE vote_end_date < ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, date);
			rs = stmt.executeQuery();


			while(rs.next()){
				contest = new Contest();
				contest.setContest_id(rs.getInt("contest_id"));
				contest.setName(rs.getString("contest_name"));
				contest.setStart_date(rs.getDate("vote_start_date"));
				contest.setEnd_date(rs.getDate("vote_end_date"));
				list.add(contest);
			}

		}catch(Exception e){
			contest = null;
			System.out.println("databaseerror"+e);
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println("2databaseerror"+e);
			}
		}

		return list;
	}

	public String getContestName(int contestid){
		String contestname="ななし";

		try{
			connection();

			String sql = "SELECT contest_name FROM contest "
					+ "WHERE contest_id=  ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,contestid);
			rs = stmt.executeQuery();


			if(rs.next()){
				contestname=rs.getString("contest_name");
			}

		}catch(Exception e){
			System.out.println("databaseerror"+e);
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println("2databaseerror"+e);
			}
		}

		return contestname;
	}

	public Contest getContestDetail(int contest_id){

		Contest contest = new Contest();

		try{
			connection();

			String sql = "SELECT * FROM contest WHERE contest_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,  contest_id);
			rs = stmt.executeQuery();

			if(rs.next()){

				contest.setName(rs.getString("contest_name"));
				contest.setEntry_start_date(rs.getDate("entry_start_date"));
				contest.setEntry_end_date(rs.getDate("entry_end_date"));
				contest.setVote_start_date(rs.getDate("vote_start_date"));
				contest.setVote_end_date(rs.getDate("vote_end_date"));
				contest.setPrize(rs.getString("prize"));
				contest.setTheme(rs.getString("theme"));
				contest.setQualifications(rs.getString("qualifications"));
			}
		}catch(Exception e){
		}finally{
			try{
				close();
			}catch(Exception e){

				}
			}

		return contest;
	}

	public String convertDate(java.sql.Date date){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String stdate = sdf.format(date);

		return stdate;
	}
}