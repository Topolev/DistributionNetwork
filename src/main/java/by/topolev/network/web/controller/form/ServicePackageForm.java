package by.topolev.network.web.controller.form;

import java.util.Set;
import java.util.TreeSet;

import by.topolev.network.domain.Permition;

public class ServicePackageForm {
	private Long id;
	private String name;
	private String description;
	private Set<Permition> permitions = new TreeSet<>();
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
