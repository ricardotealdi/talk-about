package br.com.tealdi.talkabout.converter;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.data.dto.SubjectDTO;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.model.SubjectComment;
import br.com.tealdi.talkabout.viewmodel.SubjectViewModel;

@Component
public class SubjectConverterImpl implements SubjectConverter {

	private final SubjectCommentConverter commentConverter;

	public SubjectConverterImpl(SubjectCommentConverter commentConverter) {
		this.commentConverter = commentConverter;
	}
	
	public Subject toModel(SubjectDTO dto) {
		return dto != null
			? convertToModel(dto)
			: Subject.Null();
	}
	
	public SubjectDTO toDto(Subject model) {
		SubjectDTO daoSubject = new SubjectDTO();
		daoSubject.setId(model.getId());
		daoSubject.setName(model.getName());
		
		return daoSubject;
	}
	
	private Subject convertToModel(SubjectDTO dao) {
		Subject modelSubject = new Subject(dao.getName());
		modelSubject.setId(dao.getId());
		
		return modelSubject;
	}

	public SubjectViewModel toViewModel(
			Subject model,
			List<SubjectComment> comments) {
		SubjectViewModel viewModel = new SubjectViewModel();
		
		viewModel.setId(model.getId());
		viewModel.setName(model.getName());
		
		viewModel.setComments(commentConverter.toViewModel(comments));
		
		return viewModel;
	}
}
