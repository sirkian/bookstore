package koulu.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long userid;
	
	@Size(min = 1, max = 20)
	@Column(name = "firstname")
	private String firstName;
	
	@Size(min = 1, max = 20)
	@Column(name = "lastname")
	private String lastName;
	
	@Size(min = 1, max = 20)
	private String email;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	public AppUser() {};
	
	public AppUser(String firstName, String lastName, String email, String role, String username, String passwordHash) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.username = username;
		this.passwordHash = passwordHash;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@Override
	public String toString() {
		return "AppUser [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role
				+ ", username=" + username + ", passwordHash=" + passwordHash + "]";
	}
	
	

}
