package by.topolev.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import by.topolev.network.config.ConfigClass;

public class FileTest {
	public static void main(String[] args) {
		File file = new File(ConfigClass.DEFAULT_PATH_CSV_FILE+"test1.txt");

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println(file.getAbsolutePath());
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());
			try {
				out.print("HUI");
			} finally {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
