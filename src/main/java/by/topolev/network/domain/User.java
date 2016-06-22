package by.topolev.network.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreateUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastSignin;
	
	private boolean markNotificationInactive;
	
	@Column(name = "firstname", nullable = false, columnDefinition = "varchar(255) default ''")
	private String firstname = "";
	
	@Column(name = "lastname", nullable = false, columnDefinition = "varchar(255) default ''")
	private String lastname = "";
	
	@Column(name = "nameOrganization", nullable = false, columnDefinition = "varchar(255) default ''")
	private String nameOrganization="";
	
	
	@Column(name = "urlAvatar", nullable = false, columnDefinition = "varchar(255) default 'profile.jpg'")
	private String urlAvatar="profile.jpg";

	
	private String password;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="user_role",
			joinColumns = {@JoinColumn(name="user_id")},
			inverseJoinColumns = {@JoinColumn(name="role_id")}
	)
	private Set<Role> roles = new HashSet<Role>();

	@ManyToOne
	@JoinColumn (name="SERVICE_PACKAGE_ID")
	private ServicePackage servicePackage;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void setRole(Role role){
		this.roles.add(role);
	}

	public ServicePackage getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(ServicePackage servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNameOrganization() {
		return nameOrganization;
	}

	public void setNameOrganization(String nameOrganization) {
		this.nameOrganization = nameOrganization;
	}

	public String getUrlAvatar() {
		return urlAvatar;
	}

	public void setUrlAvatar(String urlAvatar) {
		this.urlAvatar = urlAvatar;
	}

	public Date getDateCreateUser() {
		return dateCreateUser;
	}

	public void setDateCreateUser(Date dateCreateUser) {
		this.dateCreateUser = dateCreateUser;
	}

	public Date getLastSignin() {
		return lastSignin;
	}

	public void setLastSignin(Date lastSignin) {
		this.lastSignin = lastSignin;
	}

	public boolean isMarkNotificationInactive() {
		return markNotificationInactive;
	}

	public void setMarkNotificationInactive(boolean markNotificationInactive) {
		this.markNotificationInactive = markNotificationInactive;
	}
	
	
}
