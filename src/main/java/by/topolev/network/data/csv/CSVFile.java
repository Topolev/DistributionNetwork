package by.topolev.network.data.csv;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import by.topolev.network.config.ConfigClass;
import by.topolev.network.web.controller.CatalogData;

public class CSVFile {
	private Class<?> classEntity;
	private List<Field> fieldsClassEntity = new ArrayList<Field>();
	private List<String> entityRowsInString = new ArrayList<String>();
	private Object[] entityRowsInJSON;

	public void prepareClassEntity(String nameClass) throws TemplateNameClassNotFound {
		try {
			classEntity = (Class<?>) Class.forName(ConfigClass.DEFAULT_PACKAGE_CATALOG_POJO + "." + nameClass);
		} catch (ClassNotFoundException e) {
			throw new TemplateNameClassNotFound();
		}
	}

	public void prepareFieldsClassEntity(String rowFields, String delimiter) throws FieldInTemplateClassNotFound {
		String[] nameFields = rowFields.split(delimiter);
		for (String nameField : nameFields) {
			try {
				fieldsClassEntity.add(classEntity.getDeclaredField(nameField));
			} catch (Exception e) {
				throw new FieldInTemplateClassNotFound();
			}
		}
	}
	
	public void prepareFieldsClassEntity(Class<?> clazz) throws FieldInTemplateClassNotFound {
		for (Field field : clazz.getDeclaredFields()){
			if (!field.getName().equals("id")){
				fieldsClassEntity.add(field);
			}
		}
	}
	

	public void createCSVFile(InputStream stream) throws InvalidCSVException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String row;
			if ((row = reader.readLine()) != null) {
				prepareClassEntity(row);
			}
			if ((row = reader.readLine()) != null) {
				prepareFieldsClassEntity(row, ";");
			}
			while ((row = reader.readLine()) != null) {
				entityRowsInString.add(row);
			}
		} catch (Exception e) {
			throw new InvalidCSVException();
		}
	}
	
	public void createCSVFile(CatalogData data) throws InvalidCSVException{
		try{
			prepareClassEntity(data.getNameClass());
			prepareFieldsClassEntity(classEntity);
			entityRowsInJSON = data.getTable();
		} catch (Exception e){
			throw new InvalidCSVException();
		}
	}

	public String getRowFields(String delimiter){
		StringBuffer sb = new StringBuffer();
		for (Field field : fieldsClassEntity){
			sb.append(field.getName() + delimiter);
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	

	
	public Class<?> getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(Class<?> classEntity) {
		this.classEntity = classEntity;
	}

	public List<Field> getFieldsClassEntity() {
		return fieldsClassEntity;
	}

	public void setFieldsClassEntity(List<Field> fieldsClassEntity) {
		this.fieldsClassEntity = fieldsClassEntity;
	}

	public List<String> getEntityRowsInString() {
		return entityRowsInString;
	}

	public void setEntityRowsInString(List<String> entityRowsInString) {
		this.entityRowsInString = entityRowsInString;
	}

	public Object[] getEntityRowsInJSON() {
		return entityRowsInJSON;
	}

	public void setEntityRowsInJSON(Object[] entityRowsInJSON) {
		this.entityRowsInJSON = entityRowsInJSON;
	}
}
