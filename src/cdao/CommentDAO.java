package cdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import vmodel.Comment;

public class CommentDAO {
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


	public void addComment(Comment c){

        try{
            connection();

            String sql = "INSERT INTO comment(art_id,user_id,comment) VALUES(?.?.?) ";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getArt_id());
            stmt.setInt(2, c.getUser_id());
            stmt.setString(3, c.getComment());


            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            try{
                close();
            }catch(Exception e){

            }
        }
    }

}



