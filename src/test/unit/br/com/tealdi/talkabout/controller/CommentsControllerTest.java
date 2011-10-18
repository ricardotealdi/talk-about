package br.com.tealdi.talkabout.controller;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.tealdi.talkabout.converter.SubjectCommentConverter;
import br.com.tealdi.talkabout.model.SubjectComment;
import br.com.tealdi.talkabout.repository.SubjectCommentRepository;
import br.com.tealdi.talkabout.viewmodel.SubjectCommentViewModel;
import br.com.tealdi.talkabout.viewmodel.SubjectViewModel;

public class CommentsControllerTest {

	private CommentsController controller;
	private Result mockedResult;
	private SubjectCommentConverter mockedSubjectCommentConverter;
	private SubjectCommentRepository mockedSubjectCommentRepository;
	private SubjectCommentViewModel aComment;
	private SubjectCommentViewModel aEmptyComment;
	private SubjectViewModel aSubject;
	private SubjectComment convertedModel;
	private SubjectsController mockedSubjectsController;

	@Before
	public void setUp() {
		aEmptyComment = new SubjectCommentViewModel();
		
		aComment = new SubjectCommentViewModel();
		aComment.setComment("comment");
		aComment.setCommentersEmail("commentersEmail");
		
		aSubject = new SubjectViewModel();
		aSubject.setId(42);
		
		convertedModel = new SubjectComment("", "", 42);
		
		mockedSubjectsController = mock(SubjectsController.class);
		
		mockedResult = mock(Result.class);
		when(mockedResult.redirectTo(SubjectsController.class))
			.thenReturn(mockedSubjectsController);
		
		mockedSubjectCommentConverter = mock(SubjectCommentConverter.class);
		when(mockedSubjectCommentConverter
				.toModel(isA(SubjectCommentViewModel.class), anyInt()))
			.thenReturn(convertedModel);
		
		mockedSubjectCommentRepository = mock(SubjectCommentRepository.class);
		
		controller = new CommentsController(
				mockedResult, 
				mockedSubjectCommentConverter, 
				mockedSubjectCommentRepository);
	}
	
	@Test
	public void shouldConvertToModel() {
		controller.save(aComment, aSubject);
		
		verify(mockedSubjectCommentConverter, times(1))
			.toModel(aComment, aSubject.getId());
	}
	
	@Test
	public void shouldSaveComment() {
		controller.save(aComment, aSubject);
		
		verify(mockedSubjectCommentRepository, times(1))
			.save(convertedModel);
	}
	
	@Test
	public void shouldNotConvertToModelWhenReceiveAnEmptyComment() {
		controller.save(aEmptyComment, aSubject);
		
		verify(mockedSubjectCommentConverter, times(0))
			.toModel(aComment, aSubject.getId());
	}
	
	@Test
	public void shouldNotSaveCommentWhenReceiveAnEmptyComment() {
		controller.save(aEmptyComment, aSubject);
		
		verify(mockedSubjectCommentRepository, times(0))
			.save(convertedModel);
	}
	
	@Test
	public void shouldRedirectToSubjectsController() {
		controller.save(aComment, aSubject);
		
		verify(mockedResult, times(1))
			.redirectTo(SubjectsController.class);
	}
	
	@Test
	public void shouldRedirectToSearchByNameMethodOnSubjectsController() {
		controller.save(aComment, aSubject);
		
		verify(mockedSubjectsController, times(1))
			.byName(aSubject.getName());
	}
}
