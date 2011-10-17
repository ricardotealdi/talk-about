package br.com.tealdi.talkabout.data.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT_COMMENTS")
public class SubjectCommentDTO {

	private int id;
	private String comment;
	private String commentersEmail;
	private int subjectId;
	private Date createdAt;
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setComment(String name) {
		this.comment = name;
	}
	
	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	@Column(name = "commenters_email")
	public String getCommentersEmail() {
		return commentersEmail;
	}

	public void setCommentersEmail(String commentersEmail) {
		this.commentersEmail = commentersEmail;
	}

	@Column(name = "subject_id", nullable = false)
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	@Column(name = "created_at", updatable = false)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
