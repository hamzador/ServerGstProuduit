package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO )
	@Column(name = "USER_ID")
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@Column(unique = true)//username unique
	private String username;
		
	private String password;
	
	
	private Boolean enable;
	
	@ManyToMany(fetch=FetchType.EAGER)//if we put lazy we select the list of user without roles
	@JoinTable(name = "USERS_ROLES",
			joinColumns = {@JoinColumn(name = "USER_ID")},
			inverseJoinColumns = {@JoinColumn(name ="ROLE_ID")}
			)
	
	private List<Role> roles;
	
	
	
	public User() {
		super();
		
	}


	public User(String username, String password, Boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
	}


	
	
	public User(String firstName, String lastName, String username, String password, Boolean enable,
			List<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.roles = roles;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Boolean getEnable() {
		return enable;
	}


	public void setEnable(Boolean enable) {
		this.enable = enable;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	

}
