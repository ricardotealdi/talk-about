package br.com.tealdi.talkabout.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subjects")
public class SubjectDao {

	private int id;
	private String name;
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
}
