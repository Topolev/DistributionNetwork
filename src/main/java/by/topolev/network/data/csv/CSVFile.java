package by.topolev.network.data.csv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.topolev.network.data.catalog.sample.Transformer;

public class CSVFile {
	private Class<?> classEntity;
	private List<Field> fields = new ArrayList<Field>();
	private List<String> rows = new ArrayList<String>();
	public static final String  DEFAULT_PACKAGE_OF_ENTITY = "by.topolev.network.data.catalog.sample";
	
	/*  Format header: 
	 * 	<ClassNameEntityCatalog> ; <Fields list of entity>*/
	public void setHeaderFile(String strHeader) throws TemplateNameClassNotFound, FieldInTemplateClassNotFound{
		String[] elements = strHeader.split(";");
		for (int i=0; i<elements.length; i++){
			String element = elements[i].trim();
			if (i==0){
				try {
					classEntity = Class.forName(DEFAULT_PACKAGE_OF_ENTITY + "." + element);
				} catch (ClassNotFoundException e) {
					throw new TemplateNameClassNotFound();
				}
			} else {
				Field field = null;
				try {
					field = classEntity.getDeclaredField(element);
				} catch (NoSuchFieldException | SecurityException e) {
					throw new FieldInTemplateClassNotFound();
				}
				fields.add(field);
			}
		}
	}
	
	public void addRow(String row){
		rows.add(row);
	}
	
	public Class<?> getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(Class<?> classEntity) {
		this.classEntity = classEntity;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public List<String> getRows() {
		return rows;
	}

	public void setRows(List<String> rows) {
		this.rows = rows;
	}

	public static void main(String[] args) {
		CSVFile file = new CSVFile();
		
		try {
			file.setHeaderFile("Transformer;sNom;type");
		} catch (TemplateNameClassNotFound | FieldInTemplateClassNotFound e) {
			e.printStackTrace();
		} 
		
		file.addRow("100;“Ã√-100");
		file.addRow("200;“Ã√-200");
		
		CSVFileReader<Transformer> csvFileReader = new CSVFileReader<Transformer>();
		Collection<Transformer> collection = new ArrayList<Transformer>();
		
		try {
			collection = csvFileReader.read(file);
		} catch (IllegalArgumentException | IllegalAccessException | TemplateNameClassNotFound
				| FieldInTemplateClassNotFound e) {
			e.printStackTrace();
		}
		System.out.println(collection);
		
	}
}
