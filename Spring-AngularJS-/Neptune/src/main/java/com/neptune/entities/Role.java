package com.neptune.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Boubacar KOITA alias Tocka
 * @class Role entity
 *
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ROLE_ID")
	private String role;
	private String description;

	public Role() {
		super();
	}

	public Role(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
