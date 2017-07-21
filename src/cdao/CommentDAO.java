package cdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import cmodel.Comment;

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

	//コメント一覧取得
	public ArrayList<Comment> selectComment(int art_id){

		ArrayList<Comment> list = new ArrayList<Comment>();

		try{
			connection();

			String sql = "SELECT comment FROM comment WHERE art_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, art_id);
			rs = stmt.executeQuery();

			while(rs.next()){

				Comment comment = new Comment();

				comment.setComment(rs.getString("comment"));

				list.add(comment);
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

	//コメント投稿
	public void insertComment(int art_id, int user_id, String comment){

		try{
			connection();

			String sql = "INSERT INTO comment(art_id, user_id, comment)"
					+ "VALUES (?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, art_id);
			stmt.setInt(2, user_id);
			stmt.setString(3, comment);

			stmt.executeUpdate();

		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
}