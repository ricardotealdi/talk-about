package br.com.tealdi.talkabout;

import br.com.tealdi.talkabout.data.DatabaseAccess;
import br.com.tealdi.talkabout.data.DatabaseAccessImpl;

public abstract class DatabaseDependentTest {

	private DatabaseAccess databaseAccess;

	public DatabaseAccess getDatabaseAccess() {
		return databaseAccess != null 
			? databaseAccess
			: (databaseAccess = new DatabaseAccessImpl());
	}
}
