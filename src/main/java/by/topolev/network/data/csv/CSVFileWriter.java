package by.topolev.network.data.csv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import by.topolev.network.data.catalog.sample.Transformer;
import by.topolev.network.reflection.ReflectionClass;

public class CSVFileWriter<DTO> {

	public String prepareCSVData(List<DTO> collection, String delimiter) {

		Class<DTO> clazz = (Class<DTO>) collection.get(0).getClass();

		Field[] fields = clazz.getFields();

		StringBuilder sb = new StringBuilder();
		sb.append(clazz.getSimpleName() + '\n');
		sb.append(concat(fields, delimiter) + '\n');

		for (DTO row : collection) {
			for (Field field : fields) {
				try {
					sb.append(field.get(row) + delimiter);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");
		}
		return sb.toString();
	}

	public String concat(Field[] fields, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (Field field : fields) {
			sb.append(field.getName() + delimiter);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/* TEST */
	public static void main(String[] args) {
		ArrayList<Transformer> collection = new ArrayList<Transformer>();
		Transformer trans = new Transformer();
		trans.setType("TMG-100");
		collection.add(trans);

		CSVFileWriter<Transformer> entity = new CSVFileWriter<Transformer>();
		entity.prepareCSVData(collection, ";");

	}
}
