package br.com.tealdi.talkabout.converter;

import br.com.tealdi.talkabout.data.resource.SubjectDao;
import br.com.tealdi.talkabout.model.Subject;

public interface SubjectConverter {

	public abstract Subject toModel(SubjectDao dao);
	public abstract SubjectDao toDao(Subject dao);
}