package br.com.tealdi.talkabout.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.tealdi.talkabout.data.dto.SubjectCommentDTO;
import br.com.tealdi.talkabout.data.dto.SubjectDTO;

@Component
@ApplicationScoped
public class DatabaseAccessImpl implements DatabaseAccess {

	private static SessionFactory sessionFactory;

	public Session getSession() {
		return getSessionFactory().openSession();
	}
	
	private SessionFactory getSessionFactory() {
		return sessionFactory == null
				? sessionFactory = createSessionFactory()
				: sessionFactory;
	}

	private SessionFactory createSessionFactory() {
		return new Configuration()
    				.addAnnotatedClass(SubjectDTO.class)
    				.addAnnotatedClass(SubjectCommentDTO.class)
                    .configure()
                    .buildSessionFactory();
	}
}
