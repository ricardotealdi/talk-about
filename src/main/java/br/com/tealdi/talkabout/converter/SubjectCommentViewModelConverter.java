package br.com.tealdi.talkabout.converter;

import java.util.List;

import br.com.tealdi.talkabout.model.SubjectComment;
import br.com.tealdi.talkabout.viewmodel.SubjectCommentViewModel;

public interface SubjectCommentViewModelConverter {

	public abstract List<SubjectCommentViewModel> toViewModel(List<SubjectComment> comments);

}