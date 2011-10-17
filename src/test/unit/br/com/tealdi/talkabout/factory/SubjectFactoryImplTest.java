package br.com.tealdi.talkabout.factory;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class SubjectFactoryImplTest {

	@Test
	public void shouldSetNameWhenCreatingASubject() {
		assertThat(new SubjectFactoryImpl().create("name").getName())
			.isEqualTo("name");
	}
}
