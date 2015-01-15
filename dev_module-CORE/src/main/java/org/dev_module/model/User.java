package org.dev_module.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserRole> userRole = new ArrayList<UserRole>();

	@OneToMany(mappedBy = "user")
	private List<AccountReceivable> accountsReveivable = new ArrayList<AccountReceivable>();

	@ManyToMany
	@JoinTable(name = "user_caixas")
	private List<Caixa> caixas = new ArrayList<Caixa>();

	// @OneToMany(mappedBy = "usuario")
	// private List<Cliente> clientes = new ArrayList<Cliente>();

	public User() {

	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled,
			List<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	// public List<Cliente> getClientes() {
	// return clientes;
	// }
	//
	// public void setClientes(List<Cliente> clientes) {
	// this.clientes = clientes;
	// }

	public Boolean getEnabled() {
		return enabled;
	}

	public List<AccountReceivable> getAccountsReveivable() {
		return accountsReveivable;
	}

	public void setAccountsReveivable(List<AccountReceivable> accountsReveivable) {
		this.accountsReveivable = accountsReveivable;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Caixa> getCaixas() {
		return caixas;
	}

	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
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

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setDisabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}

}
