package br.com.tealdi.talkabout.service;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.factory.SubjectFactory;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.repository.SubjectRepository;

public class SubjectRetrieverImplTest {

	private SubjectRetriever retriever;
	private SubjectRepository mockedRepository;
	private SubjectFactory mockedFactory;
	private final String SUBJECT_NAME = "subject-name";
	private Subject subjectFound;
	private Subject subjectCreated;

	@Before
	public void setUp() {
		mockedRepository = mock(SubjectRepository.class);
		mockedFactory = mock(SubjectFactory.class);
		
		retriever = new SubjectRetrieverImpl(mockedRepository, mockedFactory);
	}
	
	@Test
	public void shouldRetrieveWithName() {
		givenSubjectWasFound();
		
		assertThat(retriever.with(SUBJECT_NAME)).isEqualTo(subjectFound);
	}
	
	@Test
	public void shouldGetSubjectFromRepositoryWhenRetrievingWithName() {
		givenSubjectWasFound();
		
		retriever.with(SUBJECT_NAME);
		
		verify(mockedRepository, times(1))
			.findBy(SUBJECT_NAME);
	}
	
	@Test
	public void shouldRetrieveWithNameWhenSubjectWasNotFound() {
		givenSubjectWasNotFound()
			.andNewSubjectWasCreated();
		
		assertThat(retriever.with(SUBJECT_NAME)).isEqualTo(subjectCreated);
	}
	
	@Test
	public void shouldGetSubjectFromRepositoryWhenRetrievingWithNameForANotFoundSubject() {
		givenSubjectWasNotFound()
			.andNewSubjectWasCreated();
		
		retriever.with(SUBJECT_NAME);
		
		verify(mockedRepository, times(1))
			.findBy(SUBJECT_NAME);
	}
	
	@Test
	public void shouldCreateSubjectWhenRetrievingWithNameForANotFoundSubject() {
		givenSubjectWasNotFound()
			.andNewSubjectWasCreated();
		
		retriever.with(SUBJECT_NAME);
		
		verify(mockedFactory, times(1))
			.create(SUBJECT_NAME);
	}
	
	@Test
	public void shouldSaveSubjectWhenRetrievingWithNameForANotFoundSubject() {
		givenSubjectWasNotFound()
			.andNewSubjectWasCreated();
		
		retriever.with(SUBJECT_NAME);
		
		verify(mockedRepository, times(1))
			.save(subjectCreated);
	}

	private SubjectRetrieverImplTest andNewSubjectWasCreated() {
		when(mockedFactory.create(anyString())).thenReturn(subjectCreated);
		return this;
	}

	private SubjectRetrieverImplTest givenSubjectWasNotFound() {
		when(mockedRepository.findBy(anyString())).thenReturn(Subject.Null());
		
		return this;
	}

	private void givenSubjectWasFound() {
		subjectFound = new Subject(SUBJECT_NAME);
		when(mockedRepository.findBy(anyString())).thenReturn(subjectFound);
	}
}
