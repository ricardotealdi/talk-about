package br.com.tealdi.talkabout.converter;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.data.dto.SubjectDTO;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.model.SubjectComment;
import br.com.tealdi.talkabout.viewmodel.SubjectCommentViewModel;

public class SubjectConverterImplTest {

	private SubjectDTO dtoToBeConverted;
	private SubjectConverter converter;
	private Subject modelToBeConverted;
	private SubjectCommentConverter mockedCommentConverter;
	private List<SubjectCommentViewModel> convertedViewModelComments;
	private List<SubjectComment> comments;

	@Before
	public void setUp() {
		dtoToBeConverted = new SubjectDTO();
		dtoToBeConverted.setId(1);
		dtoToBeConverted.setName("a-name");
		
		modelToBeConverted = new Subject("a-model");
		modelToBeConverted.setId(2);
		
		setUpCommentConverter();
		
		converter = new SubjectConverterImpl(mockedCommentConverter);
	}

	@SuppressWarnings("unchecked")
	private void setUpCommentConverter() {
		comments = new ArrayList<SubjectComment>(); 
		
		mockedCommentConverter = mock(SubjectCommentConverter.class);
		
		convertedViewModelComments = new ArrayList<SubjectCommentViewModel>();
		
		when(mockedCommentConverter.toViewModel(isA(List.class)))
			.thenReturn(convertedViewModelComments);
	}
	
	@Test
	public void shouldSetIdWhenConvertingToModel() {		
		Subject modelConverted = converter.toModel(dtoToBeConverted);
		
		assertThat(modelConverted.getId()).isEqualTo(1);
	}
	
	@Test
	public void shouldSetNameWhenConvertingToModel() {
		Subject modelConverted = converter.toModel(dtoToBeConverted);
		
		assertThat(modelConverted.getName()).isEqualTo("a-name");
	}
	
	@Test
	public void shouldBeANullSubjectWhenConvertingToModelANullDao() {
		Subject modelConverted = converter.toModel(null);
		
		assertThat(modelConverted).isEqualTo(Subject.Null());
	}
	
	@Test
	public void shouldSetIdWhenConvertingToDto() {
		SubjectDTO dtoConverted = converter.toDto(modelToBeConverted);
		
		assertThat(dtoConverted.getId()).isEqualTo(modelToBeConverted.getId());
	}
	
	@Test
	public void shouldSetNameWhenConvertingToDao() {
		SubjectDTO dtoConverted = converter.toDto(modelToBeConverted);
		
		assertThat(dtoConverted.getName()).isEqualTo(modelToBeConverted.getName());
	}
	
	@Test
	public void shouldSetIdWhenConvertingToViewModel() {
		assertThat(converter.toViewModel(modelToBeConverted, comments).getId())
				.isEqualTo(modelToBeConverted.getId());
	}
	
	@Test
	public void shouldSetNameWhenConvertingToViewModel() {
		assertThat(converter.toViewModel(modelToBeConverted, comments).getName())
				.isEqualTo(modelToBeConverted.getName());
	}
	
	@Test
	public void shouldSetCommentsWhenConvertingToViewModel() {
		assertThat(converter.toViewModel(modelToBeConverted, comments).getComments())
				.isEqualTo(convertedViewModelComments);
	}
}
