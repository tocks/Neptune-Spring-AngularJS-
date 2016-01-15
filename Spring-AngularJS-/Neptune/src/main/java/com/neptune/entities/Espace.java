package com.neptune.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="ESPACES")
public class Espace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESPACE_ID")
	private Long espaceId;
	private String espaceName;
	private String espaceDescription;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="COMPANY_ID")
	private Company espaceCompany;
	private Date created;
	
	
	public Espace() {
		super();
	}
	
	
	public Espace(String espaceName, String espaceDescription, Company espaceCompany, Date created) {
		super();
		this.espaceName = espaceName;
		this.espaceDescription = espaceDescription;
		this.espaceCompany = espaceCompany;
		this.created = created;
	}


	public Long getEspaceId() {
		return espaceId;
	}
	public void setEspaceId(Long espaceId) {
		this.espaceId = espaceId;
	}
	public String getEspaceName() {
		return espaceName;
	}
	public void setEspaceName(String espaceName) {
		this.espaceName = espaceName;
	}
	public String getEspaceDescription() {
		return espaceDescription;
	}
	public void setEspaceDescription(String espaceDescription) {
		this.espaceDescription = espaceDescription;
	}
	public Company getEspaceCompany() {
		return espaceCompany;
	}
	public void setEspaceComany(Company espaceComany) {
		this.espaceCompany = espaceComany;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
