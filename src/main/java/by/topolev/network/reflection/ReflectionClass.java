package by.topolev.network.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import by.topolev.network.data.catalog.sample.Transformer;

public class ReflectionClass {
	public static List<String> getListFieldsClass(Class clazz){
		List<String> listFields = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields){
			listFields.add(field.getName());
		}
		return listFields;
	}
	public static String getStringFieldsClass(Class clazz, String delimiter){
		List<String> listFieldsClass = getListFieldsClass(clazz);
		StringBuilder sb = new StringBuilder();
		for (String field : listFieldsClass){
			sb.append(field + delimiter);
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	public static void main(String[] args){
		Transformer transformator = new Transformer();
		System.out.println(getListFieldsClass(transformator.getClass()));
		getStringFieldsClass(transformator.getClass(), ";");
	}
}
