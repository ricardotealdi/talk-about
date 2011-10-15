package br.com.tealdi.talkabout.converter;

import br.com.tealdi.talkabout.data.dto.SubjectDTO;
import br.com.tealdi.talkabout.model.Subject;

public interface SubjectConverter {

	public abstract Subject toModel(SubjectDTO dao);
	public abstract SubjectDTO toDao(Subject dao);
}