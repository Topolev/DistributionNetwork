package by.topolev.network.data.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.topolev.network.config.ConfigClass;

public class CSVFileReader<DTO> {

	public DTO createPOJO(String row, String delimiter, Class<?> clazz) {
		String[] valueFields = row.split(delimiter);
		return null;
	}

	public Class<DTO> prepareClassPOJO(String nameClass) throws TemplateNameClassNotFound {
		Class<DTO> classEntity;
		try {
			classEntity = (Class<DTO>) Class.forName(ConfigClass.DEFAULT_PACKAGE_CATALOG_POJO + "." + nameClass);
		} catch (ClassNotFoundException e) {
			throw new TemplateNameClassNotFound();
		}
		return classEntity;
	}

	public List<Field> getListFields(String rowFields, String delimiter, Class<DTO> clazz)
			throws FieldInTemplateClassNotFound {
		String[] nameFields = rowFields.split(delimiter);
		List<Field> listFields = new ArrayList<Field>();
		for (String nameField : nameFields) {
			try {
				listFields.add(clazz.getDeclaredField(nameField));
			} catch (Exception e) {
				throw new FieldInTemplateClassNotFound();
			}
		}
		return listFields;
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

	public List<DTO> read(InputStream stream, String delimiter) throws InvalidCSVException  {

		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		List<DTO> collection = new ArrayList<DTO>();

		try {
			String nameClassDTO = reader.readLine();
			Class<DTO> classEntity = prepareClassPOJO(nameClassDTO);

			String rowFields = reader.readLine();
			List<Field> listFields = getListFields(rowFields, delimiter, classEntity);

			String row;
			while ((row = reader.readLine()) != null) {
				collection.add(prepareDTO(row, delimiter, listFields, classEntity));
			}
		} catch (Exception e) {
			throw new InvalidCSVException();
		}
		return collection;
	}

/*	public Collection<DTO> read(CSVFile file) throws TemplateNameClassNotFound, FieldInTemplateClassNotFound,
			IllegalArgumentException, IllegalAccessException {
		Collection<DTO> collections = new ArrayList<DTO>();
		for (String row : file.getRows()) {
			String[] elements = row.split(";");
			DTO instance = null;
			try {
				instance = (DTO) file.getClassEntity().newInstance();
			} catch (Exception e) {
				throw new TemplateNameClassNotFound();
			}
			int i = 0;
			for (Field field : file.getFields()) {
				String value = elements[i].trim();
				field.setAccessible(true);
				field.set(instance, getValueWithTypeOfField(value, field));
				field.setAccessible(false);
				i++;
			}
			collections.add(instance);
		}
		return collections;
	}*/

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
