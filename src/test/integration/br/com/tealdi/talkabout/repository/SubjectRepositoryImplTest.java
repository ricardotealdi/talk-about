package br.com.tealdi.talkabout.repository;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.DatabaseDependentTest;
import br.com.tealdi.talkabout.dao.Subject;

import static org.fest.assertions.Assertions.assertThat;

public class SubjectRepositoryImplTest extends DatabaseDependentTest {

	private SubjectRepository repository;

	@Before
	public void setUp() {
		repository = new SubjectRepositoryImpl(getDatabaseAccess()); 
	}
	
	@Test
	public void shouldFindByName() {
		givenThereIsOneSubjectOnDatabase();
		
		Subject subjectFound = repository.findBy("a-subject");
		
		assertThat(subjectFound.getId()).isEqualTo(1);
		assertThat(subjectFound.getName()).isEqualTo("a-subject");
	}

	private void givenThereIsOneSubjectOnDatabase() {
		Subject subjectToBeAdded = createSubject(1, "a-subject");
		
		persistIt(subjectToBeAdded);
	}

	private void persistIt(Subject subjectToBeAdded) {
		Session session = getDatabaseAccess().getSession();
		session.beginTransaction();
		session.save(subjectToBeAdded);
		session.getTransaction().commit();
		session.close();
	}

	private Subject createSubject(int id, String subject) {
		Subject subjectToBeAdded = new Subject();
		subjectToBeAdded.setId(id);
		subjectToBeAdded.setName(subject);
		return subjectToBeAdded;
	}
}
