package com.neptune.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="propespections")
public class Prospection implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String comment;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Customer customer;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="CUST_ID")
	private Customer propsectionOwner;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private ProspectionStatus prospectionStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getOwner() {
		return propsectionOwner;
	}

	public void setOwner(Customer owner) {
		this.propsectionOwner = owner;
	}

	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ProspectionStatus getProspectionStatus() {
		return prospectionStatus;
	}

	public void setProspectionStatus(ProspectionStatus prospectionStatus) {
		this.prospectionStatus = prospectionStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Customer getPropsectionOwner() {
		return propsectionOwner;
	}

	public void setPropsectionOwner(Customer propsectionOwner) {
		this.propsectionOwner = propsectionOwner;
	}
	
	

}
