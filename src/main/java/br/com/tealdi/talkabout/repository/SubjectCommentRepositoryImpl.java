package br.com.tealdi.talkabout.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.tealdi.talkabout.converter.SubjectCommentConverter;
import br.com.tealdi.talkabout.data.DatabaseAccess;
import br.com.tealdi.talkabout.data.dto.SubjectCommentDTO;
import br.com.tealdi.talkabout.model.Subject;
import br.com.tealdi.talkabout.model.SubjectComment;

public class SubjectCommentRepositoryImpl implements SubjectCommentRepository {

	private final DatabaseAccess databaseAccess;
	private final SubjectCommentConverter converter;

	public SubjectCommentRepositoryImpl(
			DatabaseAccess databaseAccess,
			SubjectCommentConverter converter) {
		this.databaseAccess = databaseAccess;
		this.converter = converter;
	}
	
	@SuppressWarnings("unchecked")
	public List<SubjectComment> findFor(Subject subject) {
		Session session = databaseAccess.getSession();
		List<SubjectCommentDTO> commentsFound = 
				(List<SubjectCommentDTO>) session
					.createCriteria(SubjectCommentDTO.class)
					.add(Restrictions.eq("subjectId", subject.getId()))
					.list();
		
		return commentsFound.size() > 0
				? convertToModel(commentsFound)
				: new ArrayList<SubjectComment>();
	}

	private List<SubjectComment> convertToModel(List<SubjectCommentDTO> commentsFound) {
		List<SubjectComment> models = new ArrayList<SubjectComment>();
		
		for(SubjectCommentDTO comment : commentsFound) {
			models.add(converter.toModel(comment));
		}
		
		return models;
	}

}
