package br.com.tealdi.talkabout.converter;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.data.dto.SubjectDTO;
import br.com.tealdi.talkabout.model.Subject;

public class SubjectConverterImplTest {

	private SubjectDTO dtoToBeConverted;
	private SubjectConverter converter;
	private Subject modelToBeConverted;

	@Before
	public void setUp() {
		dtoToBeConverted = new SubjectDTO();
		dtoToBeConverted.setId(1);
		dtoToBeConverted.setName("a-name");
		
		modelToBeConverted = new Subject("a-model");
		modelToBeConverted.setId(2);
		
		converter = new SubjectConverterImpl();
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
}
