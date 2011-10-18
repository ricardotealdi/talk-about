package br.com.tealdi.talkabout.service;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.factory.SubjectFactory;
import br.com.tealdi.talkabout.helper.Hyphenator;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.repository.SubjectRepository;

public class SubjectRetrieverImplTest {

	private static final String SUBJECT_NAME_HYPHENIZED = "subject-name-hyphenized";
	private SubjectRetriever retriever;
	private SubjectRepository mockedRepository;
	private SubjectFactory mockedFactory;
	private final String SUBJECT_NAME = "subject-name";
	private Subject subjectFound;
	private Subject subjectCreated;
	private Hyphenator mockedHyphenator;

	@Before
	public void setUp() {
		mockedHyphenator = mock(Hyphenator.class);
		when(mockedHyphenator.hyphenizeIt(anyString()))
			.thenReturn(SUBJECT_NAME_HYPHENIZED);
		
		mockedRepository = mock(SubjectRepository.class);
		mockedFactory = mock(SubjectFactory.class);
		
		retriever = new SubjectRetrieverImpl(mockedHyphenator, mockedRepository, mockedFactory);
	}
	
	@Test
	public void shouldRetrieveWithName() {
		givenSubjectWasFound();
		
		assertThat(retriever.with(SUBJECT_NAME)).isEqualTo(subjectFound);
	}
	
	@Test
	public void shouldHyphenizeTextWhenRetrievingWithName() {
		givenSubjectWasFound();
		
		retriever.with(SUBJECT_NAME);
		
		verify(mockedHyphenator, times(1))
			.hyphenizeIt(SUBJECT_NAME);
	}
	
	@Test
	public void shouldGetSubjectFromRepositoryWhenRetrievingWithName() {
		givenSubjectWasFound();
		
		retriever.with(SUBJECT_NAME);
		
		verify(mockedRepository, times(1))
			.findBy(SUBJECT_NAME_HYPHENIZED);
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
			.findBy(SUBJECT_NAME_HYPHENIZED);
	}
	
	@Test
	public void shouldCreateSubjectWhenRetrievingWithNameForANotFoundSubject() {
		givenSubjectWasNotFound()
			.andNewSubjectWasCreated();
		
		retriever.with(SUBJECT_NAME);
		
		verify(mockedFactory, times(1))
			.create(SUBJECT_NAME_HYPHENIZED);
	}
	
	@Test
	public void shouldSaveSubjectWhenRetrievingWithNameForANotFoundSubject() {
		givenSubjectWasNotFound()
			.andNewSubjectWasCreated();
		
		retriever.with(SUBJECT_NAME);
		
		verify(mockedRepository, times(1))
			.save(subjectCreated);
	}
	
	@Test
	public void shouldHyphenizeTextWhenRetrievingWithNameForANotFoundSubject() {
		givenSubjectWasNotFound()
			.andNewSubjectWasCreated();
		
		retriever.with(SUBJECT_NAME);
		
		verify(mockedHyphenator, times(1))
			.hyphenizeIt(SUBJECT_NAME);
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
