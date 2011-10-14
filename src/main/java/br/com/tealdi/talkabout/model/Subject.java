package br.com.tealdi.talkabout.model;

public class Subject {
	
	private String name;
	private int id;
	
	private static final Subject nullSubject = new Subject("");

	public Subject(String name) {
		this.setName(name);
	}
	
	public static Subject Null() {
		return nullSubject;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
