package br.com.tealdi.talkabout.data;

import org.hibernate.Session;


public interface DatabaseAccess {

	public abstract Session getSession();

}