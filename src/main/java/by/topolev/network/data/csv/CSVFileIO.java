package by.topolev.network.data.csv;

import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import by.topolev.network.config.ConfigClass;

public class CSVFileIO<DTO> {

	public List<DTO> readCSVFileFromString(CSVFile file) throws InvalidCSVException{
		List<DTO> collection = new ArrayList<DTO>();
		List<String> entityRows = file.getEntityRowsInString(); 
		for (String row: entityRows){
			try{
				collection.add(prepareDTO(row, ConfigClass.DEFAULT_DELIMITER_CSV, file.getFieldsClassEntity(), (Class<DTO>)file.getClassEntity()));
			} catch (Exception e){
				throw new InvalidCSVException();
			}
		}
		return collection;
	}
	
	public List<DTO> readCSVFileFromJSON(CSVFile file) throws InvalidCSVException{
		List<DTO> collection = new ArrayList<DTO>();
		Object[] entityRows = file.getEntityRowsInJSON();
		for (Object row : entityRows) {
			Map<String, String> map = (Map<String, String>) row;
			ObjectMapper mapper = new ObjectMapper();
			collection.add((DTO) mapper.convertValue(map, file.getClassEntity()));
		}
		return collection;
	}
	
	public String writeCSVFileJSON(CSVFile file) throws InvalidCSVException{
		StringBuilder sb = new StringBuilder();
		try{
			sb.append(file.getClassEntity().getSimpleName()+'\n');
			sb.append(file.getRowFields(ConfigClass.DEFAULT_DELIMITER_CSV)+ '\n');
			for (DTO entity : readCSVFileFromJSON(file)){
				for (Field field : file.getFieldsClassEntity()){
					sb.append(field.get(entity) + ConfigClass.DEFAULT_DELIMITER_CSV);
				}
				sb.deleteCharAt(sb.length()-1).append('\n');
			}
			
		} catch (Exception e){
			throw new InvalidCSVException();
		}
		return sb.toString();
	}
	
	public DTO prepareDTO(String rowDTO, String delimiter, List<Field> listFields, Class<DTO> clazz)
			throws InvalidCSVData {
		DTO instance;
		String[] valueFields = rowDTO.split(delimiter);
		try {
			instance = (DTO) clazz.newInstance();
			int i = 0;
			for (Field field : listFields) {
				String value = valueFields[i].trim();
				field.setAccessible(true);
				field.set(instance, getValueWithTypeOfField(value, field));
				field.setAccessible(false);
				i++;
			}
		} catch (Exception e) {
			throw new InvalidCSVData();
		}
		return instance;
	}

	public static Object getValueWithTypeOfField(String value, Field field) {

		if (field.getType().getName().equals(float.class.getName())) {
			return Float.valueOf(value).floatValue();
		}
		if (field.getType().getName().equals(int.class.getName())) {
			return Integer.valueOf(value).intValue();
		}
		if (field.getType().getName().equals(String.class.getName())) {
			return value;
		}
		return null;
	}

}
