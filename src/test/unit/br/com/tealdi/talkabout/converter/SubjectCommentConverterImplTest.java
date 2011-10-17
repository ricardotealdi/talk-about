package br.com.tealdi.talkabout.converter;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.data.dto.SubjectCommentDTO;
import br.com.tealdi.talkabout.model.SubjectComment;

import static org.fest.assertions.Assertions.assertThat;

public class SubjectCommentConverterImplTest {

	private SubjectCommentConverter converter;
	private SubjectCommentDTO aDto;

	@Before
	public void setUp() {
		aDto = new SubjectCommentDTO();
		aDto.setId(1);
		aDto.setComment("my comment");
		aDto.setCommentersEmail("my-email@test.com");
		aDto.setSubjectId(42);
		aDto.setCreatedAt(new Date());
		
		converter = new SubjectCommentConverterImpl();
	}
	
	@Test
	public void shouldSetIdWhenConvertingToModel() {
		SubjectComment commentConverted = converter.toModel(aDto);
		assertThat(commentConverted.getId()).isEqualTo(aDto.getId());
	}
	
	@Test
	public void shouldSetCommentWhenConvertingToModel() {
		SubjectComment commentConverted = converter.toModel(aDto);
		assertThat(commentConverted.getComment()).isEqualTo(aDto.getComment());
	}
	
	@Test
	public void shouldSetCommentersEmailWhenConvertingToModel() {
		SubjectComment commentConverted = converter.toModel(aDto);
		assertThat(commentConverted.getCommentersEmail()).isEqualTo(aDto.getCommentersEmail());
	}
	
	@Test
	public void shouldSetSubjectIdWhenConvertingToModel() {
		SubjectComment commentConverted = converter.toModel(aDto);
		assertThat(commentConverted.getSubjectId()).isEqualTo(aDto.getSubjectId());
	}
	
	@Test
	public void shouldSetCreatedAtWhenConvertingToModel() {
		SubjectComment commentConverted = converter.toModel(aDto);
		assertThat(commentConverted.getCreatedAt()).isEqualTo(aDto.getCreatedAt());
	}
	
	@Test
	public void shouldBeANullSubjectCommentWhenConvertingToModel() {
		assertThat(converter.toModel(null)).isEqualTo(SubjectComment.Null());
	}
}
