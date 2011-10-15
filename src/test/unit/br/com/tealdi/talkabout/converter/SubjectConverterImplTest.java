package br.com.tealdi.talkabout.converter;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.data.resource.SubjectDao;
import br.com.tealdi.talkabout.model.Subject;

public class SubjectConverterImplTest {

	private SubjectDao daoToBeConverted;
	private SubjectConverter converter;
	private Subject modelToBeConverted;

	@Before
	public void setUp() {
		daoToBeConverted = new SubjectDao();
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
		SubjectDao daoConverted = converter.toDao(modelToBeConverted);
		
		assertThat(daoConverted.getId()).isEqualTo(modelToBeConverted.getId());
	}
	
	@Test
	public void shouldSetNameWhenConvertingToDao() {
		SubjectDao daoConverted = converter.toDao(modelToBeConverted);
		
		assertThat(daoConverted.getName()).isEqualTo(modelToBeConverted.getName());
	}
}
