package by.topolev.test;

import org.apache.commons.lang.StringEscapeUtils;

public class StringUtil {

	public static void main(String[] args) {
		
		String str = "<div>DDD</a>Hello";
		String str1 = StringEscapeUtils.escapeHtml(str);
		System.out.println(str1);

	}

}
