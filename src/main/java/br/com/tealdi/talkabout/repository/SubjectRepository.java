package br.com.tealdi.talkabout.repository;

import br.com.tealdi.talkabout.dao.SubjectDao;

public interface SubjectRepository {
	public abstract SubjectDao findBy(String name);
}