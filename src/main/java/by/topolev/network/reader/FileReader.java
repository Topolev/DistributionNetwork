package by.topolev.network.reader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReader {
	private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
	private static String fileName = "C://a.txt";
	
	public static void main(String[] args){
		FileReader.write(fileName, text);
	}
	
	public static void write(String fileName, String text){
		File file = new File(fileName);
		try{
			if (!file.exists()){
				file.createNewFile();
			}
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());
			try{
				out.print(text);
			} finally{
				out.close();
			}
		} catch (IOException e){
			throw new RuntimeException(e);
		}
	}
	
}
