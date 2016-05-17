package by.topolev.network.data.catalog.sample;

public class Transformer implements CatalogDTO {
	public Long id;
	public String type;
	public float s;
	public float uVN;
	public float uNN;
	public float pHH;
	public float pKZ;
	public float uk;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public float getuVN() {
		return uVN;
	}
	public void setuVN(float uVN) {
		this.uVN = uVN;
	}
	public float getuNN() {
		return uNN;
	}
	public void setuNN(float uNN) {
		this.uNN = uNN;
	}
	public float getpHH() {
		return pHH;
	}
	public void setpHH(float pHH) {
		this.pHH = pHH;
	}
	public float getpKZ() {
		return pKZ;
	}
	public void setpKZ(float pKZ) {
		this.pKZ = pKZ;
	}
	public float getUk() {
		return uk;
	}
	public void setUk(float uk) {
		this.uk = uk;
	}
	
	public String toString(){
		return "type: " + type;
	}
}
