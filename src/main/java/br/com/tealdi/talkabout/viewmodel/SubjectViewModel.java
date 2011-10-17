package br.com.tealdi.talkabout.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class SubjectViewModel {
	
	private int id;
	private String name;
	private List<SubjectCommentViewModel> comments;
	
	public SubjectViewModel() {
		comments = new ArrayList<SubjectCommentViewModel>();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setComments(List<SubjectCommentViewModel> comments) {
		this.comments = comments;
	}
	public List<SubjectCommentViewModel> getComments() {
		return comments;
	}
}
