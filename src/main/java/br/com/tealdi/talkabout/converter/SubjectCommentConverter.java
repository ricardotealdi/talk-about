package br.com.tealdi.talkabout.converter;

import br.com.tealdi.talkabout.data.dto.SubjectCommentDTO;
import br.com.tealdi.talkabout.model.SubjectComment;

public interface SubjectCommentConverter {
	public abstract SubjectComment toModel(SubjectCommentDTO dto);
}
