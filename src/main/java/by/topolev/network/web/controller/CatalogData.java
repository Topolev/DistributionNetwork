package by.topolev.network.web.controller;

import java.util.List;

import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.data.catalog.sample.Transformer;

public class CatalogData {

	private String nameClass;
	private Object[] table;
	public String getNameClass() {
		return nameClass;
	}
	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}
	public Object[] getTable() {
		return table;
	}
	public void setTable(Object[] table) {
		this.table = table;
	}


	
}
