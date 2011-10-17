package br.com.tealdi.talkabout.factory;

import br.com.tealdi.talkabout.model.Subject;

public interface SubjectFactory {

	public abstract Subject create(String name);

}