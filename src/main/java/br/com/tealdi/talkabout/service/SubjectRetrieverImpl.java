package br.com.tealdi.talkabout.service;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.factory.SubjectFactory;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.repository.SubjectRepository;

@Component
public class SubjectRetrieverImpl implements SubjectRetriever {
	
	private final SubjectRepository repository;
	private final SubjectFactory factory;

	public SubjectRetrieverImpl(
			SubjectRepository repository,
			SubjectFactory factory) {
		this.repository = repository;
		this.factory = factory;
	}
	
	public Subject with(String name) {
		Subject subjectFound = repository.findBy(name);
		
		if(subjectFound == Subject.Null()) {
			subjectFound = factory.create(name);
			repository.save(subjectFound);
		}
		
		return subjectFound;
	}
}
