package br.com.tealdi.talkabout.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.converter.SubjectConverter;
import br.com.tealdi.talkabout.data.DatabaseAccess;
import br.com.tealdi.talkabout.data.resource.SubjectDao;
import br.com.tealdi.talkabout.model.Subject;

@Component
public class SubjectRepositoryImpl implements SubjectRepository {

	private DatabaseAccess databaseAccess;
	private final SubjectConverter subjectConverter;

	public SubjectRepositoryImpl(
			DatabaseAccess databaseAccess,
			SubjectConverter subjectConverter) {
		this.databaseAccess = databaseAccess;
		this.subjectConverter = subjectConverter;
	}
	
	public Subject findBy(String name) {
		Session session = databaseAccess.getSession();
		
		SubjectDao subjectsFound = findByName(name, session);
		
		session.close();
		
		return subjectConverter.toModel(subjectsFound);
	}

	@SuppressWarnings("unchecked")
	private SubjectDao findByName(String name, Session session) {
		List<SubjectDao> rowsFound = (List<SubjectDao>) session
			.createCriteria(SubjectDao.class)
			.add(Restrictions.eq("name", name))
			.list();
		
		return rowsFound.isEmpty() ? null : rowsFound.get(0);
	}

	public void save(Subject subjectToSave) {
		Session session = databaseAccess.getSession();

		session.beginTransaction();
		SubjectDao dao = subjectConverter.toDao(subjectToSave);
		session.saveOrUpdate(dao);
		session.getTransaction().commit();
		session.close();
		
		subjectToSave.setId(dao.getId());
	}
}
