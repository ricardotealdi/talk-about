package br.com.tealdi.talkabout.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tealdi.talkabout.converter.SubjectConverter;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.model.SubjectComment;
import br.com.tealdi.talkabout.repository.SubjectCommentRepository;
import br.com.tealdi.talkabout.service.SubjectRetriever;

@Resource
public class SubjectsController {
	
	private final Result result;
	private final SubjectRetriever subjectRetriever;
	private final SubjectConverter converter;
	private final SubjectCommentRepository commentRepository;

	public SubjectsController(
			Result result,
			SubjectRetriever subjectRetriever,
			SubjectCommentRepository commentsRepository,
			SubjectConverter converter) {
		this.result = result;
		this.subjectRetriever = subjectRetriever;
		this.commentRepository = commentsRepository;
		this.converter = converter;
	}
	
	@Get("/{subject}")
	public void byName(String subject) {
		Subject subjectFound = subjectRetriever.with(subject);
		
		List<SubjectComment> commentsFound = commentRepository.findFor(subjectFound);
		
		result.include("subject", converter.toViewModel(subjectFound, commentsFound));
	}
}
