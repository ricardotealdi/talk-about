package br.com.tealdi.talkabout.factory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.model.Subject;

@Component
public class SubjectFactoryImpl implements SubjectFactory {

	public Subject create(String name) {
		return new Subject(name);
	}
}
