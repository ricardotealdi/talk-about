package br.com.tealdi.talkabout.controller;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tealdi.talkabout.converter.SubjectCommentConverter;
import br.com.tealdi.talkabout.repository.SubjectCommentRepository;
import br.com.tealdi.talkabout.viewmodel.SubjectCommentViewModel;
import br.com.tealdi.talkabout.viewmodel.SubjectViewModel;

@Resource
public class CommentsController {
	
	private final Result result;
	private final SubjectCommentConverter converter;
	private final SubjectCommentRepository repository;

	public CommentsController(
			Result result,
			SubjectCommentConverter converter,
			SubjectCommentRepository repository) {
				this.result = result;
				this.converter = converter;
				this.repository = repository;
	}
	
	@Post("/comments/save")
	public void save(SubjectCommentViewModel comment, SubjectViewModel subject) {
		repository.save(converter.toModel(comment, subject.getId()));
		
		result.redirectTo(SubjectsController.class).byName(subject.getName());
	}
}
