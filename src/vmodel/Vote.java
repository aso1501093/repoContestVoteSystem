package vmodel;

import java.io.Serializable;

public class Vote implements Serializable{
	int user_id;
	int contest_id;
	int art_id;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getContest_id() {
		return contest_id;
	}
	public void setContest_id(int contest_id) {
		this.contest_id = contest_id;
	}
	public int getArt_id() {
		return art_id;
	}
	public void setArt_id(int art_id) {
		this.art_id = art_id;
	}
	
	

}
