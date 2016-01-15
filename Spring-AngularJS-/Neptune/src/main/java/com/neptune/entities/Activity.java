package com.neptune.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "activities")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String activity;
	private String descriprion;
	@ManyToOne()
	@JoinTable(name = "ACTIVITY_OWNER")
	private User user;

	public Activity() {
		super();
	}

	public Activity(String activity, String descriprion) {
		super();
		this.activity = activity;
		this.descriprion = descriprion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDescriprion() {
		return descriprion;
	}

	public void setDescriprion(String descriprion) {
		this.descriprion = descriprion;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
