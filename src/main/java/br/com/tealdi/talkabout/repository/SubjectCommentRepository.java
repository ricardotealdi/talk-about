package br.com.tealdi.talkabout.repository;

import java.util.List;

import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.model.SubjectComment;

public interface SubjectCommentRepository {
	public List<SubjectComment> findFor(Subject subject);
}
