package br.com.tealdi.talkabout.repository;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.dao.Subject;
import br.com.tealdi.talkabout.helper.DatabaseAccess;

@Component
public class SubjectRepositoryImpl implements SubjectRepository {

	private DatabaseAccess databaseAccess;

	public SubjectRepositoryImpl(DatabaseAccess databaseAccess) {
		this.databaseAccess = databaseAccess;
	}
	
	public Subject findBy(String name) {
		Session session = databaseAccess.getSession();
		
		Subject subjectFound = 
			(Subject) session
				.createCriteria(Subject.class)
				.add(Restrictions.eq("name", name))
				.list()
				.get(0);
		
		session.close();
		
		return subjectFound;
	}
}
