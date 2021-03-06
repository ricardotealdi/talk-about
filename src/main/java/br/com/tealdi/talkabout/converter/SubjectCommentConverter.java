package br.com.tealdi.talkabout.converter;

import java.util.List;

import br.com.tealdi.talkabout.data.dto.SubjectCommentDTO;
import br.com.tealdi.talkabout.model.SubjectComment;
import br.com.tealdi.talkabout.viewmodel.SubjectCommentViewModel;

public interface SubjectCommentConverter {
	public abstract SubjectComment toModel(SubjectCommentDTO dto);
	public abstract SubjectCommentDTO toDto(SubjectComment model);
	public abstract SubjectComment toModel(SubjectCommentViewModel commentViewModel, int subjectId);
	public abstract List<SubjectCommentViewModel> toViewModel(List<SubjectComment> comments);
}
