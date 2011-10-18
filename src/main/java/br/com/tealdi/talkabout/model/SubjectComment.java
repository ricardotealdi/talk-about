package br.com.tealdi.talkabout.model;

import java.util.Date;

public class SubjectComment {
	private int id;
	private String comment;
	private String commentersEmail;
	private int subjectId;
	private Date createdAt;
	
	public SubjectComment(
			String comment, 
			String commentersEmail,			
			int subjectId) {
		this.comment = comment;
		this.commentersEmail = commentersEmail;
		this.subjectId = subjectId;
		this.createdAt = new Date();
	}
	
	private static final SubjectComment nullSubjectComment = 
			new SubjectComment("", "", 0);
	
	public static SubjectComment Null() {
		return nullSubjectComment;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentersEmail() {
		return commentersEmail;
	}
	public void setCommentersEmail(String commentersEmail) {
		this.commentersEmail = commentersEmail;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
