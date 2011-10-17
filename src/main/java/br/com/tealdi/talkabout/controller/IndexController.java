package br.com.tealdi.talkabout.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tealdi.talkabout.helper.Hyphenator;

@Resource
public class IndexController {
	
	private final Result result;
	private final Hyphenator hyphenator;

	public IndexController(
			Result result,
			Hyphenator hyphenator){
		this.result = result;
		this.hyphenator = hyphenator;
	}

	@Get("/")
	public void index() {
	}
	
	@Post("/")
	public void redirectToSubject(String subject) {
		result
			.redirectTo(SubjectsController.class)
			.byName(hyphenator.hyphenizeIt(subject));
	}
}
