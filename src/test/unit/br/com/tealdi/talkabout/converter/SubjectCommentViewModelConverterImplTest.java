package br.com.tealdi.talkabout.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.talkabout.model.SubjectComment;

import static org.fest.assertions.Assertions.assertThat;

public class SubjectCommentViewModelConverterImplTest {

	private SubjectCommentViewModelConverter converter;
	private SubjectComment firstComment;
	private SubjectComment secondComment;
	private List<SubjectComment> comments;

	@Before
	public void setUp() {
		converter = new SubjectCommentViewModelConverterImpl();
		
		createComments();
	}
	
	@Test
	public void shouldHaveSameSizeWhenConvertingToViewModel() {
		assertThat(converter.toViewModel(comments))
			.hasSize(comments.size());
	}
	
	@Test
	public void shouldConvertCommentWhenConvertingToViewModel() {
		assertThat(converter.toViewModel(comments).get(0).getComment())
			.isEqualTo(firstComment.getComment());
		
		assertThat(converter.toViewModel(comments).get(1).getComment())
			.isEqualTo(secondComment.getComment());
	}
	
	@Test
	public void shouldConvertCommentersEmailWhenConvertingToViewModel() {
		assertThat(converter.toViewModel(comments).get(0).getCommentersEmail())
			.isEqualTo(firstComment.getCommentersEmail());
		
		assertThat(converter.toViewModel(comments).get(1).getCommentersEmail())
			.isEqualTo(secondComment.getCommentersEmail());
	}

	private void createComments() {
		firstComment = new SubjectComment(
				"first-comment", 
				"first-email", 
				1, 
				new Date());
		
		secondComment = new SubjectComment(
				"second-comment", 
				"second-email", 
				2, 
				new Date());
		
		comments = new ArrayList<SubjectComment>();
		comments.add(firstComment);
		comments.add(secondComment);
	}
}
