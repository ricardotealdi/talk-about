package br.com.tealdi.talkabout.controller;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tealdi.talkabout.viewmodel.SubjectCommentViewModel;

@Resource
public class CommentsController {
	
	@Post("/comments/save")
	public void save(SubjectCommentViewModel comment, int subjectId) {
		
	}
}
