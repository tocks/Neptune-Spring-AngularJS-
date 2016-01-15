package com.neptune.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String password;
	private boolean actived;

	@ManyToMany
	@JoinTable(name = "USER_ROLES")
	private Collection<Role> roles;
	
	@OneToMany(mappedBy = "user")
	private Collection<Activity> activities;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	@XmlTransient
	public Collection<Role> getRoles() {
		return roles;
	}

	@JsonSetter
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Activity> getActivities() {
		return activities;
	}

	@JsonSetter
	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}
	
	

}
