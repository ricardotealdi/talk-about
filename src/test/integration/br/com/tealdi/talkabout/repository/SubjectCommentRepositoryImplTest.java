package br.com.tealdi.talkabout.repository;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.DatabaseDependentTest;
import br.com.tealdi.talkabout.converter.SubjectCommentConverterImpl;
import br.com.tealdi.talkabout.data.dto.SubjectCommentDTO;
import br.com.tealdi.talkabout.data.dto.SubjectDTO;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.model.SubjectComment;

public class SubjectCommentRepositoryImplTest extends DatabaseDependentTest {

	private SubjectCommentRepository repository;
	private SubjectDTO aSubject;
	private Date aDate;
	private SubjectCommentDTO firstCommentDto;
	private SubjectCommentDTO secondCommentDto;
	private Session session;

	@Before
	public void setUp() {
		session = getDatabaseAccess().getSession();
		repository = new SubjectCommentRepositoryImpl(getDatabaseAccess(), new SubjectCommentConverterImpl());
	}
	
	@After
	public void tearDown() {
		session.close();
	}
	
	@Test
	public void shouldFindAllCommentsForASubject() {
		givenThereAreTwoSubjectOnDatabase()
			.andFourComments();

		Subject subject = new Subject(aSubject.getName());
		subject.setId(aSubject.getId());
		
		List<SubjectComment> commentsFound = repository.findFor(subject);
		
		assertThat(commentsFound).hasSize(2);
	}

	private void andFourComments() {		
		aDate = new Date();
		session.beginTransaction();
		session.save(firstCommentDto = createComment(1, "first-comment", "first-email", aSubject.getId(), aDate));
		session.save(secondCommentDto = createComment(2, "second-comment", "second-email", aSubject.getId(), aDate));
		session.save(createComment(3, "third-comment", "third-email", 2, aDate));
		session.save(createComment(4, "fourth-comment", "fourth-email", 2, aDate));
		session.getTransaction().commit();
	}

	private SubjectCommentRepositoryImplTest givenThereAreTwoSubjectOnDatabase() {
		session.beginTransaction();
		session.save(aSubject = createSubject(1, "first"));
		session.save(createSubject(2, "second"));
		session.getTransaction().commit();
		return this;
	}

	private SubjectDTO createSubject(int id, String subject) {
		SubjectDTO subjectToBeAdded = new SubjectDTO();
		subjectToBeAdded.setId(id);
		subjectToBeAdded.setName(subject);
		return subjectToBeAdded;
	}

	private SubjectCommentDTO createComment(
			int id, 
			String comment,
			String commentersEmail,
			int subjectId,
			Date createdAt) {
		SubjectCommentDTO commentToBeAdded = new SubjectCommentDTO();
		
		commentToBeAdded.setId(id);
		commentToBeAdded.setComment(comment);
		commentToBeAdded.setCommentersEmail(commentersEmail);
		commentToBeAdded.setCreatedAt(createdAt);
		commentToBeAdded.setId(id);
		commentToBeAdded.setSubjectId(subjectId);
		
		return commentToBeAdded;
	}
}
