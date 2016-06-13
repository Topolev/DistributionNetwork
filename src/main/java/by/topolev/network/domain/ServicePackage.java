package by.topolev.network.domain;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ServicePackage {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String description;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="servicePackage_permition",
			joinColumns = @JoinColumn(name="servicePackage_id"),
			inverseJoinColumns = @JoinColumn(name="permition_id"))
	private Set<Permition> permitions = new TreeSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Permition> getPermitions() {
		return permitions;
	}
	public void setPermitions(Set<Permition> permitions) {
		this.permitions = permitions;
	}
	
}
