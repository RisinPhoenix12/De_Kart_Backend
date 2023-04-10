package com.deloitte.mockProj.backend.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Table(name="user",schema="de_kart")
@Entity
public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public User() {
		super();
	}
	public User(int user_id, String username, String address, String password, String role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.address = address;
		this.password = password;
		this.role = role;
	}


	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	@Column
	private String username;
	
	@Column
	private String address;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getRole() {
		return role;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", address=" + address + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
	
}
