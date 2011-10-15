package br.com.tealdi.talkabout.converter;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.data.resource.SubjectDao;
import br.com.tealdi.talkabout.model.Subject;

@Component
public class SubjectConverterImpl implements SubjectConverter {

	public Subject toModel(SubjectDao dao) {
		return dao != null
			? convertToModel(dao)
			: Subject.Null();
	}
	
	public SubjectDao toDao(Subject model) {
		SubjectDao daoSubject = new SubjectDao();
		daoSubject.setId(model.getId());
		daoSubject.setName(model.getName());
		
		return daoSubject;
	}
	
	private Subject convertToModel(SubjectDao dao) {
		Subject modelSubject = new Subject(dao.getName());
		modelSubject.setId(dao.getId());
		
		return modelSubject;
	}
}
