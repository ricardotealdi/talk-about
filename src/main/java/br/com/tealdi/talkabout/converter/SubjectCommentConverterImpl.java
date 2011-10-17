package br.com.tealdi.talkabout.converter;

import br.com.tealdi.talkabout.data.dto.SubjectCommentDTO;
import br.com.tealdi.talkabout.model.SubjectComment;

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

}
