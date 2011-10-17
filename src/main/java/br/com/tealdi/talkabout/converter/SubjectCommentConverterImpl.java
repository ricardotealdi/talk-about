package br.com.tealdi.talkabout.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.data.dto.SubjectCommentDTO;
import br.com.tealdi.talkabout.model.SubjectComment;
import br.com.tealdi.talkabout.viewmodel.SubjectCommentViewModel;

@Component
public class SubjectCommentConverterImpl implements SubjectCommentConverter {

	public SubjectComment toModel(SubjectCommentDTO dto) {
		return dto != null
				? convertToModel(dto)
				: SubjectComment.Null();
	}

	private SubjectComment convertToModel(SubjectCommentDTO dto) {
		SubjectComment model = 
				new SubjectComment(
						dto.getComment(), 
						dto.getCommentersEmail(), 
						dto.getSubjectId(), 
						dto.getCreatedAt());
		model.setId(dto.getId());
		
		return model;
	}

	public List<SubjectCommentViewModel> toViewModel(List<SubjectComment> comments) {
		List<SubjectCommentViewModel> commentsViewModel = new ArrayList<SubjectCommentViewModel>();
		
		for(SubjectComment comment : comments) {
			commentsViewModel.add(toViewModel(comment));
		}
		
		return commentsViewModel;
	}
	
	private SubjectCommentViewModel toViewModel(SubjectComment comment) {
		SubjectCommentViewModel commentViewModel = new SubjectCommentViewModel();
		
		commentViewModel.setComment(comment.getComment());
		commentViewModel.setCommentersEmail(comment.getCommentersEmail());
		
		return commentViewModel;
	}

	public SubjectComment toModel(SubjectCommentViewModel commentViewModel, int subjectId) {
		SubjectComment model = 
			new SubjectComment(
					commentViewModel.getComment(), 
					commentViewModel.getCommentersEmail(), 
					subjectId,
					new Date());
		
		return model;
	}
}
