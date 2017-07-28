package cmodel;

import java.io.Serializable;
import java.sql.Date;


public class Contest implements Serializable {
	int contest_id;
	String name;
	Date start_date;
	Date end_date;
	String overview;
	String termtext;
	String theme;
	String prize;
	String qualifications;
	Date vote_start_date;
	Date vote_end_date;
	Date entry_start_date;
	Date entry_end_date;

	public Date getEntry_start_date() {
		return entry_start_date;
	}
	public void setEntry_start_date(Date entry_start_date) {
		this.entry_start_date = entry_start_date;
	}
	public Date getEntry_end_date() {
		return entry_end_date;
	}
	public void setEntry_end_date(Date entry_end_date) {
		this.entry_end_date = entry_end_date;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getPrize() {
		return prize;

	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public Date getVote_start_date() {
		return vote_start_date;
	}
	public void setVote_start_date(Date vote_start_date) {
		this.vote_start_date = vote_start_date;
	}
	public Date getVote_end_date() {
		return vote_end_date;
	}
	public void setVote_end_date(Date vote_end_date) {
		this.vote_end_date = vote_end_date;
	}
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
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
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
