package br.com.tealdi.talkabout.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.tealdi.talkabout.helper.Hyphenator;

public class IndexControllerTest {

	private static final String SUBJECT = "subject";
	private static final String HYPHENIZED_SUBJECT = "hyphenized-subject";
	private IndexController controller;
	private Result mockedResult;
	private Hyphenator mockedHyphenator;
	private SubjectsController mockedSubjectsController;

	@Before
	public void setUp() {
		mockedResult = mock(Result.class);
		
		mockedHyphenator = mock(Hyphenator.class);
		when(mockedHyphenator.hyphenizeIt(anyString()))
			.thenReturn(HYPHENIZED_SUBJECT);
		
		mockedSubjectsController = mock(SubjectsController.class);
		
		when(mockedResult.redirectTo(SubjectsController.class))
			.thenReturn(mockedSubjectsController);
		
		controller = new IndexController(mockedResult, mockedHyphenator);
	}
	
	@Test
	public void shouldRedirectToSubjectController() {
		controller.redirectToSubject(SUBJECT);
		
		verify(mockedResult, times(1))
			.redirectTo(SubjectsController.class);
	}
	
	@Test
	public void shouldRedirectToSubjectControllerSearchByName() {
		controller.redirectToSubject(SUBJECT);
		
		verify(mockedSubjectsController, times(1))
			.byName(HYPHENIZED_SUBJECT);
	}
	
	@Test
	public void shouldHyphenizeSubjectWhenRedirectingToSubjectsController() {
		controller.redirectToSubject(SUBJECT);
		
		verify(mockedHyphenator, times(1))
			.hyphenizeIt(SUBJECT);
	}
}
