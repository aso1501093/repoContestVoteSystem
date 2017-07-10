package cdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import cmodel.User;


public class UserDAO {
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
//		Class.forName("com.mysql.jdbc.Driver");
//		con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:8890/StudentsSystem", "root", "root");
//		return con;
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

	public User selectAdmin(int id, String password){

		User user = new User();

		try{
			connection();

			String sql = "SELECT * FROM user "
					+ "WHERE user_id=? AND "
					+ "user_password=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			
			if(rs.next()){
				user.setUser_id(rs.getInt("user_id"));
				user.setPassword(rs.getString("user_password"));
			}else{
				user = null;
			}

		}catch(Exception e){
			user = null;
			System.out.println("databaseerror"+e);;
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println("2databaseerror"+e);;
			}
		}

		return user;
	}

}
