package br.com.tealdi.talkabout.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.data.dto.SubjectCommentDTO;
import br.com.tealdi.talkabout.model.SubjectComment;

import static org.fest.assertions.Assertions.assertThat;

public class SubjectCommentConverterImplTest {

	private SubjectCommentConverter converter;
	private SubjectCommentDTO aDto;
	private SubjectComment firstModelComment;
	private SubjectComment secondModelComment;
	private List<SubjectComment> twoModelComments;

	@Before
	public void setUp() {
		aDto = new SubjectCommentDTO();
		aDto.setId(1);
		aDto.setComment("my comment");
		aDto.setCommentersEmail("my-email@test.com");
		aDto.setSubjectId(42);
		aDto.setCreatedAt(new Date());
		
		createComments();
		
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
	
	@Test
	public void shouldHaveSameSizeWhenConvertingToViewModel() {
		assertThat(converter.toViewModel(twoModelComments))
			.hasSize(twoModelComments.size());
	}
	
	@Test
	public void shouldConvertCommentWhenConvertingToViewModel() {
		assertThat(converter.toViewModel(twoModelComments).get(0).getComment())
			.isEqualTo(firstModelComment.getComment());
		
		assertThat(converter.toViewModel(twoModelComments).get(1).getComment())
			.isEqualTo(secondModelComment.getComment());
	}
	
	@Test
	public void shouldConvertCommentersEmailWhenConvertingToViewModel() {
		assertThat(converter.toViewModel(twoModelComments).get(0).getCommentersEmail())
			.isEqualTo(firstModelComment.getCommentersEmail());
		
		assertThat(converter.toViewModel(twoModelComments).get(1).getCommentersEmail())
			.isEqualTo(secondModelComment.getCommentersEmail());
	}

	private void createComments() {
		firstModelComment = new SubjectComment(
				"first-comment", 
				"first-email", 
				1, 
				new Date());
		
		secondModelComment = new SubjectComment(
				"second-comment", 
				"second-email", 
				2, 
				new Date());
		
		twoModelComments = new ArrayList<SubjectComment>();
		twoModelComments.add(firstModelComment);
		twoModelComments.add(secondModelComment);
	}
}
