package br.com.tealdi.talkabout.service;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.factory.SubjectFactory;
import br.com.tealdi.talkabout.helper.Hyphenator;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.repository.SubjectRepository;

@Component
public class SubjectRetrieverImpl implements SubjectRetriever {
	
	private final SubjectRepository repository;
	private final SubjectFactory factory;
	private final Hyphenator hyphenator;

	public SubjectRetrieverImpl(
			Hyphenator hyphenator,
			SubjectRepository repository,
			SubjectFactory factory) {
		this.hyphenator = hyphenator;
		this.repository = repository;
		this.factory = factory;
	}
	
	public Subject with(String name) {
		String hyphenizedSubjectName = hyphenator.hyphenizeIt(name);
		Subject subjectFound = repository.findBy(hyphenizedSubjectName);
		
		if(subjectFound == Subject.Null()) {
			subjectFound = factory.create(hyphenizedSubjectName);
			repository.save(subjectFound);
		}
		
		return subjectFound;
	}
}
