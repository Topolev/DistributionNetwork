package by.topolev.network.data.catalog.sample;

public class OverheadLine implements CatalogDTO{
	public Long id;
	public String type;
	public float s;
	public float u;
	public float r0;
	public float x0;
	public float i;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getS() {
		return s;
	}
	public void setS(float s) {
		this.s = s;
	}
	public float getU() {
		return u;
	}
	public void setU(float u) {
		this.u = u;
	}
	public float getR0() {
		return r0;
	}
	public void setR0(float r0) {
		this.r0 = r0;
	}
	public float getX0() {
		return x0;
	}
	public void setX0(float x0) {
		this.x0 = x0;
	}
	public float getI() {
		return i;
	}
	public void setI(float i) {
		this.i = i;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
