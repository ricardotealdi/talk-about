package br.com.tealdi.talkabout.helper;

import org.hibernate.Session;


public interface DatabaseAccess {

	public abstract Session getSession();

}