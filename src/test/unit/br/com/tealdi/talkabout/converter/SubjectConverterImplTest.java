package br.com.tealdi.talkabout.converter;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.dao.SubjectDao;
import br.com.tealdi.talkabout.model.Subject;

public class SubjectConverterImplTest {

	private SubjectDao daoToBeConverted;
	private SubjectConverterImpl converter;

	@Before
	public void setUp() {
		daoToBeConverted = new SubjectDao();
		daoToBeConverted.setId(1);
		daoToBeConverted.setName("a-name");
		
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
}
