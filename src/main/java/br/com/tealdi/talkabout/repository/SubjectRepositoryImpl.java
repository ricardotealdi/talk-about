package br.com.tealdi.talkabout.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.converter.SubjectConverter;
import br.com.tealdi.talkabout.data.DatabaseAccess;
import br.com.tealdi.talkabout.data.dto.SubjectDTO;
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
		
		SubjectDTO subjectsFound = findByName(name, session);
		
		session.close();
		
		return subjectConverter.toModel(subjectsFound);
	}

	public void save(Subject subjectToSave) {
		Session session = databaseAccess.getSession();

		session.beginTransaction();
		SubjectDTO dao = subjectConverter.toDao(subjectToSave);
		session.saveOrUpdate(dao);
		session.getTransaction().commit();
		session.close();
		
		subjectToSave.setId(dao.getId());
	}

	@SuppressWarnings("unchecked")
	private SubjectDTO findByName(String name, Session session) {
		List<SubjectDTO> rowsFound = (List<SubjectDTO>) session
			.createCriteria(SubjectDTO.class)
			.add(Restrictions.eq("name", name))
			.list();
		
		return rowsFound.isEmpty() ? null : rowsFound.get(0);
	}
}
