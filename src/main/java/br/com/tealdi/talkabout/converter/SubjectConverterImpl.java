package br.com.tealdi.talkabout.converter;

import br.com.tealdi.talkabout.dao.SubjectDao;
import br.com.tealdi.talkabout.model.Subject;

public class SubjectConverterImpl implements SubjectConverter {

	public Subject toModel(SubjectDao dao) {
		return dao != null
			? convertToModel(dao)
			: Subject.Null();
	}
	
	private Subject convertToModel(SubjectDao dao) {
		Subject modelSubject = new Subject(dao.getName());
		modelSubject.setId(dao.getId());
		
		return modelSubject;
	}
}
