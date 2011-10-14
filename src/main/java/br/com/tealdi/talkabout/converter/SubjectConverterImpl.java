package br.com.tealdi.talkabout.converter;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.dao.SubjectDao;
import br.com.tealdi.talkabout.model.Subject;

@Component
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
