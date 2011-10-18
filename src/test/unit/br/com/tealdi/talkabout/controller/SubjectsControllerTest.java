package br.com.tealdi.talkabout.controller;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.tealdi.talkabout.converter.SubjectConverter;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.model.SubjectComment;
import br.com.tealdi.talkabout.repository.SubjectCommentRepository;
import br.com.tealdi.talkabout.service.SubjectRetriever;
import br.com.tealdi.talkabout.viewmodel.SubjectViewModel;

public class SubjectsControllerTest {

	private static final String SUBJECT = "subject";
	private SubjectsController controller;
	private Result mockedResult;
	private SubjectRetriever mockedSubjectRetriever;
	private SubjectCommentRepository mockedSubjectCommentRepository;
	private SubjectConverter mockedSubjectConverter;
	private Subject subjectRetrieved;
	private List<SubjectComment> commentsRetrieved;
	private SubjectViewModel convertedSubjectViewModel;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		subjectRetrieved = new Subject("");
		commentsRetrieved = new ArrayList<SubjectComment>();
		convertedSubjectViewModel = new SubjectViewModel();
		
		mockedResult = mock(Result.class);
		
		mockedSubjectRetriever = mock(SubjectRetriever.class);
		when(mockedSubjectRetriever.with(anyString()))
			.thenReturn(subjectRetrieved);
		
		mockedSubjectCommentRepository = mock(SubjectCommentRepository.class);
		when(mockedSubjectCommentRepository.findFor(isA(Subject.class)))
			.thenReturn(commentsRetrieved);
		
		mockedSubjectConverter = mock(SubjectConverter.class);
		when(mockedSubjectConverter.toViewModel(isA(Subject.class), isA(List.class)))
			.thenReturn(convertedSubjectViewModel);
		
		controller = new SubjectsController(
				mockedResult, 
				mockedSubjectRetriever,
				mockedSubjectCommentRepository,
				mockedSubjectConverter);
	}
	
	@Test
	public void shouldRetrieveSubject() {
		controller.byName(SUBJECT);
		
		verify(mockedSubjectRetriever, times(1)).with(SUBJECT);
	}
	
	@Test
	public void shouldRetrieveComments() {
		controller.byName(SUBJECT);
		
		verify(mockedSubjectCommentRepository, times(1))
			.findFor(subjectRetrieved);
	}
	
	@Test
	public void shouldConvertToViewModel() {
		controller.byName(SUBJECT);
		
		verify(mockedSubjectConverter, times(1))
			.toViewModel(subjectRetrieved, commentsRetrieved);
	}
	
	@Test
	public void shouldSetViewModelOnResult() {
		controller.byName(SUBJECT);
		
		verify(mockedResult, times(1))
			.include("subject", convertedSubjectViewModel);
	}
}
