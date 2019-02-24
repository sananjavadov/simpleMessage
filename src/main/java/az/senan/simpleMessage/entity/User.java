package az.senan.simpleMessage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;




@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", updatable=false)
	private int id;
	
	@Column(name="user_login", unique=true, nullable=false)
	@Size(min=3, max=20)
	@NotEmpty
	private String username;
	
	@Column(name="user_pass", nullable=false, length=100)
	@NotEmpty
	private String password;
	
	@Column(name="user_name", length=30, nullable=false)
	@NotEmpty
	private String name;
	
	@Column(name="user_surname", length=30, nullable=false)
	@NotEmpty
	private String surname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", surname="
				+ surname + "]";
	}
	
	public User() {
		
	}
	
	
	
	

}
