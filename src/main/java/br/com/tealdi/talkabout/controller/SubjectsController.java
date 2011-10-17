package br.com.tealdi.talkabout.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class SubjectsController {
	
	private final Result result;

	public SubjectsController(Result result){
		this.result = result;
	}
	
	@Get("/{subject}")
	public void byName(String subject) {
		result.include("subject", subject);
	}
}
