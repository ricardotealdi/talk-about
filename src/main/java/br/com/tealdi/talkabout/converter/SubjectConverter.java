package br.com.tealdi.talkabout.converter;

import java.util.List;

import br.com.tealdi.talkabout.data.dto.SubjectDTO;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.model.SubjectComment;
import br.com.tealdi.talkabout.viewmodel.SubjectViewModel;

public interface SubjectConverter {

	public abstract Subject toModel(SubjectDTO dto);
	public abstract SubjectDTO toDto(Subject model);
	public abstract SubjectViewModel toViewModel(Subject model, List<SubjectComment> comments);
}