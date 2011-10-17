package br.com.tealdi.talkabout.service;

import br.com.tealdi.talkabout.model.Subject;

public interface SubjectRetriever {

	public abstract Subject with(String name);

}