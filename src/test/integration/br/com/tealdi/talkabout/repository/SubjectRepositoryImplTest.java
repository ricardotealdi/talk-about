package br.com.tealdi.talkabout.repository;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.DatabaseDependentTest;
import br.com.tealdi.talkabout.converter.SubjectConverterImpl;
import br.com.tealdi.talkabout.data.resource.SubjectDao;
import br.com.tealdi.talkabout.model.Subject;

import static org.fest.assertions.Assertions.assertThat;

public class SubjectRepositoryImplTest extends DatabaseDependentTest {

	private SubjectRepository repository;

	@Before
	public void setUp() {
		repository = new SubjectRepositoryImpl(getDatabaseAccess(), new SubjectConverterImpl()); 
	}
	
	@Test
	public void shouldFindByName() {
		givenThereIsOneSubjectOnDatabase();
		
		Subject subjectFound = repository.findBy("a-subject");
		
		assertThat(subjectFound.getId()).isEqualTo(1);
		assertThat(subjectFound.getName()).isEqualTo("a-subject");
	}
	
	@Test
	public void shouldRetrieveANullSubjectWhenFindingByNameRetrievesNoResults() {
		Subject subjectFound = repository.findBy("non-persisted");
		
		assertThat(subjectFound).isEqualTo(Subject.Null());
	}
	
	@Test
	public void shouldSaveASubject() {
		Subject subjectToSave = new Subject("any-name");
		
		repository.save(subjectToSave);
		
		SubjectDao rowFound = getFromDatabase(subjectToSave.getId());
		
		assertThat(rowFound.getId()).isEqualTo(rowFound.getId());
		assertThat(rowFound.getName()).isEqualTo(rowFound.getName());
	}

	private void givenThereIsOneSubjectOnDatabase() {
		SubjectDao subjectToBeAdded = createSubject(1, "a-subject");
		
		persistIt(subjectToBeAdded);
	}

	private void persistIt(SubjectDao subjectToBeAdded) {
		Session session = getDatabaseAccess().getSession();
		session.beginTransaction();
		session.save(subjectToBeAdded);
		session.getTransaction().commit();
		session.close();
	}
	
	private SubjectDao getFromDatabase(int id) {
		Session session = getDatabaseAccess().getSession();
		SubjectDao rowFound =  (SubjectDao) session.get(SubjectDao.class, id);
		session.close();
		return rowFound;
	}

	private SubjectDao createSubject(int id, String subject) {
		SubjectDao subjectToBeAdded = new SubjectDao();
		subjectToBeAdded.setId(id);
		subjectToBeAdded.setName(subject);
		return subjectToBeAdded;
	}
}
