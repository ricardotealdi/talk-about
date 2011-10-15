package br.com.tealdi.talkabout.converter;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.data.dto.SubjectDTO;
import br.com.tealdi.talkabout.model.Subject;

public class SubjectConverterImplTest {

	private SubjectDTO daoToBeConverted;
	private SubjectConverter converter;
	private Subject modelToBeConverted;

	@Before
	public void setUp() {
		daoToBeConverted = new SubjectDTO();
		daoToBeConverted.setId(1);
		daoToBeConverted.setName("a-name");
		
		modelToBeConverted = new Subject("a-model");
		modelToBeConverted.setId(2);
		
		converter = new SubjectConverterImpl();
	}
	
	@Test
	public void shouldSetIdWhenConvertingToModel() {		
		Subject modelConverted = converter.toModel(daoToBeConverted);
		
		assertThat(modelConverted.getId()).isEqualTo(1);
	}
	
	@Test
	public void shouldSetNameWhenConvertingToModel() {
		Subject modelConverted = converter.toModel(daoToBeConverted);
		
		assertThat(modelConverted.getName()).isEqualTo("a-name");
	}
	
	@Test
	public void shouldBeANullSubjectWhenConvertingToModelANullDao() {
		Subject modelConverted = converter.toModel(null);
		
		assertThat(modelConverted).isEqualTo(Subject.Null());
	}
	
	@Test
	public void shouldSetIdWhenConvertingToDao() {
		SubjectDTO daoConverted = converter.toDao(modelToBeConverted);
		
		assertThat(daoConverted.getId()).isEqualTo(modelToBeConverted.getId());
	}
	
	@Test
	public void shouldSetNameWhenConvertingToDao() {
		SubjectDTO daoConverted = converter.toDao(modelToBeConverted);
		
		assertThat(daoConverted.getName()).isEqualTo(modelToBeConverted.getName());
	}
}
