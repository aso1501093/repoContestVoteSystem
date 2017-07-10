package vmodel;

import java.io.Serializable;
import java.sql.Date;


public class Contest implements Serializable {
	int contest_id;
	String name;
	Date star_date;
	Date end_date;
	String overview;
	String termtext;
	
	public String getTermtext() {
		return termtext;
	}
	public void setTermtext(String termtext) {
		this.termtext = termtext;
	}
	public int getContest_id() {
		return contest_id;
	}
	public void setContest_id(int contest_id) {
		this.contest_id = contest_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStar_date() {
		return star_date;
	}
	public void setStar_date(Date star_date) {
		this.star_date = star_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	

}
