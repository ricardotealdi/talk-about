package br.com.tealdi.talkabout.viewmodel;

public class SubjectCommentViewModel {
	private String comment;
	private String commentersEmail;
	
	public SubjectCommentViewModel() {
		comment = "";
		commentersEmail = "";
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getComment() {
		return comment;
	}
	public void setCommentersEmail(String commentersEmail) {
		this.commentersEmail = commentersEmail;
	}
	public String getCommentersEmail() {
		return commentersEmail;
	}
}
