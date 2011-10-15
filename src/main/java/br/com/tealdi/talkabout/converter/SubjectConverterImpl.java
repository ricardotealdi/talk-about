package br.com.tealdi.talkabout.converter;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.data.resource.SubjectDTO;
import br.com.tealdi.talkabout.model.Subject;

@Component
public class SubjectConverterImpl implements SubjectConverter {

	public Subject toModel(SubjectDTO dao) {
		return dao != null
			? convertToModel(dao)
			: Subject.Null();
	}
	
	public SubjectDTO toDao(Subject model) {
		SubjectDTO daoSubject = new SubjectDTO();
		daoSubject.setId(model.getId());
		daoSubject.setName(model.getName());
		
		return daoSubject;
	}
	
	private Subject convertToModel(SubjectDTO dao) {
		Subject modelSubject = new Subject(dao.getName());
		modelSubject.setId(dao.getId());
		
		return modelSubject;
	}
}
