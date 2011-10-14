package br.com.tealdi.talkabout.repository;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.dao.SubjectDao;
import br.com.tealdi.talkabout.helper.DatabaseAccess;

@Component
public class SubjectRepositoryImpl implements SubjectRepository {

	private DatabaseAccess databaseAccess;

	public SubjectRepositoryImpl(DatabaseAccess databaseAccess) {
		this.databaseAccess = databaseAccess;
	}
	
	public SubjectDao findBy(String name) {
		Session session = databaseAccess.getSession();
		
		SubjectDao subjectFound = 
			(SubjectDao) session
				.createCriteria(SubjectDao.class)
				.add(Restrictions.eq("name", name))
				.list()
				.get(0);
		
		session.close();
		
		return subjectFound;
	}
}
