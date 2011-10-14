package br.com.tealdi.talkabout.repository;

import br.com.tealdi.talkabout.model.Subject;

public interface SubjectRepository {
	public abstract Subject findBy(String name);
}