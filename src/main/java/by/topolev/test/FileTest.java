package by.topolev.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("help/test1.txt");

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
