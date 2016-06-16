package by.topolev.network.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UrlImage {
	@Id
	@GeneratedValue
	private Long id;
	private String urlImage;
	private boolean markUsing;
	@Temporal(TemporalType.TIME)
	private Date dataCreate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public boolean isMarkUsing() {
		return markUsing;
	}
	public void setMarkUsing(boolean markUsing) {
		this.markUsing = markUsing;
	}
	public Date getDataCreate() {
		return dataCreate;
	}
	public void setDataCreate(Date dataCreate) {
		this.dataCreate = dataCreate;
	}
	
	
}
