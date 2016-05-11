package by.topolev.network.data.csv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;


public class CSVFileReader<DTO> {
	public Collection<DTO> read(CSVFile file) throws TemplateNameClassNotFound, FieldInTemplateClassNotFound, IllegalArgumentException, IllegalAccessException{
		Collection<DTO> collections = new ArrayList<DTO>();
		for (String row : file.getRows()){
			String[] elements = row.split(";");
			DTO instance = null;
			try {
				instance =(DTO) file.getClassEntity().newInstance();
			} catch (Exception e) {
				throw new TemplateNameClassNotFound();
			}
			int i =0;
			for (Field field : file.getFields()){
				String value = elements[i].trim();
				field.setAccessible(true);
				field.set(instance, getValueWithTypeOfField(value, field));
				field.setAccessible(false);
				i++;
			}
			collections.add(instance);
		}
		return collections;
	}
	
	public static Object getValueWithTypeOfField(String value, Field field){
		
		
		if (field.getType().getName().equals(float.class.getName())){
			return Float.valueOf(value).floatValue();
		}
		if (field.getType().getName().equals(int.class.getName())){
			return Integer.valueOf(value).intValue();
		}
		if (field.getType().getName().equals(String.class.getName())){
			return value;
		}
		return null;
	}
	
	
}
