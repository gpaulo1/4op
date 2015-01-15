package com.dev_module.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Size(min = 2, max = 30)
	private String userName;

	@Temporal(TemporalType.DATE)
	private Date dateRegister;

	private String email;
	
	@OneToMany(mappedBy = "user")
	private List<Client> clients = new ArrayList<Client>();

	/**
	 * Status definition: a - active i - inactive t - test
	 */
	private char status;

	private String password;

	
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getStatus() {
		return status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
