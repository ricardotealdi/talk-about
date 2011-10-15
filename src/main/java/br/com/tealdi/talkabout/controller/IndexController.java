package br.com.tealdi.talkabout.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tealdi.talkabout.data.dto.SubjectDTO;
import br.com.tealdi.talkabout.helper.Hyphenator;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.repository.SubjectRepository;

@Resource
public class IndexController {

	private final Result result;
	private final Hyphenator hyphenator;
	private final SubjectRepository repository;

	public IndexController(
			Result result, 
			Hyphenator hyphenator,
			SubjectRepository repository) {
		this.result = result;
		this.hyphenator = hyphenator;
		this.repository = repository;
	}

	@Path("/")
	public void index() {
		String text = hyphenator.hyphenizeIt(" - testing this -");
		
		SubjectDTO subject = new SubjectDTO();
		subject.setName(text);
		//repository.save(subject);
		
		Subject subjectFound = repository.findBy(text);
		
		result.include("variable", "VRaptor!");		
		result.include("text", hyphenator.hyphenizeIt("çaramba meu, vamos *?_--+=!@#$%^&*()"));
		result.include("subject", subjectFound);
	}

}
