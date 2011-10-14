package br.com.tealdi.talkabout.converter;

import br.com.tealdi.talkabout.dao.SubjectDao;
import br.com.tealdi.talkabout.model.Subject;

public interface SubjectConverter {

	public abstract Subject toModel(SubjectDao dao);

}