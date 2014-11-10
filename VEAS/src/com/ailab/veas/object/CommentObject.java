package com.ailab.veas.object;

public class CommentObject {
	private String mName;
	private String mComment;
	private String mDate;
	
	public CommentObject(){
		
	}
	
	public CommentObject(String name, String comment, String date){
		this.mName = name;
		this.mComment = comment;
		this.mDate = date;
	}
	
	
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmComment() {
		return mComment;
	}
	public void setmComment(String mComment) {
		this.mComment = mComment;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	
}
