package by.topolev.network.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import by.topolev.network.config.ConfigClass;
import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.data.csv.CSVFile;
import by.topolev.network.data.csv.CSVFileIO;
import by.topolev.network.data.csv.CSVFileIOCreator;
import by.topolev.network.data.csv.InvalidCSVException;
import by.topolev.network.web.controller.CatalogData;

@Service
public class CatalogServiceImpl implements CatalogService {
	
	
	@Override
	public List<? extends CatalogDTO> loadCatalog(InputStream inputStream) throws InvalidCSVException{
		CSVFile file = new CSVFile();
		file.createCSVFile(inputStream);
		CSVFileIO<? extends CatalogDTO> creator = CSVFileIOCreator.factory(file.getClassEntity());
		return creator.readCSVFileFromString(file);
	}
	
	@Override
	public List<? extends CatalogDTO> loadCatalog(InputStream inputStream, String nameClassEntity)
			throws InvalidCSVException {
		CSVFile file = new CSVFile();
		file.createCSVFile(inputStream);
		CSVFileIO<? extends CatalogDTO> creator = null;
		if (file.getClassEntity().getSimpleName().equals(nameClassEntity)){
			creator = CSVFileIOCreator.factory(file.getClassEntity());
		} else {
			throw new InvalidCSVException();
		}
		return creator.readCSVFileFromString(file);
	}

	@Override
	public String saveCatalogInCSV(CatalogData data) throws InvalidCSVException {
		CSVFile file = new CSVFile();
		file.createCSVFile(data);
		CSVFileIO<? extends CatalogDTO> creator = CSVFileIOCreator.factory(file.getClassEntity());
		
		String content = creator.writeCSVFileJSON(file);
		System.out.println(content);
		String nameFile = getUniqNameFile(ConfigClass.DEFAULT_PATH_CSV_FILE, "csv");
		System.out.println(nameFile);
		File outFile = new File(ConfigClass.DEFAULT_PATH_CSV_FILE + nameFile);
		System.out.println(ConfigClass.DEFAULT_PATH_CSV_FILE + nameFile);
		
		try {
			outFile.createNewFile();
			PrintWriter out = new PrintWriter(outFile);
			try {
				out.print(content);
			} finally {
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nameFile;

	}

	public File getFileCatalogInCSV(CatalogData data) throws InvalidCSVException {
		String nameFile = getUniqNameFile(ConfigClass.DEFAULT_PATH_CSV_FILE, "csv");
		File file = new File(ConfigClass.DEFAULT_PATH_CSV_FILE + nameFile);
		try{
			String content = saveCatalogInCSV(data);
			try {
				PrintWriter out = new PrintWriter(file);
				try {
					out.print(content);
				} finally {
					out.close();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (Exception e){
			 throw new InvalidCSVException();
		}
		return file;
	}

	public String getUniqNameFile(String nameDirectory, String expansionFile) {
		Random rand = new Random(Long.MAX_VALUE);
		boolean p;
		String nameFile;
		do {
			nameFile = DigestUtils.md5Hex(String.valueOf(rand.nextInt())) + "." + expansionFile;
			File file = new File(nameFile);
			p = file.exists();
		} while (p);
		return nameFile;
	}



}

