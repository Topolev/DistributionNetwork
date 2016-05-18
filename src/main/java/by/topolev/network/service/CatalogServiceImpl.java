package by.topolev.network.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import by.topolev.network.config.ConfigClass;
import by.topolev.network.data.catalog.sample.CableLine;
import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.data.catalog.sample.OverheadLine;
import by.topolev.network.data.catalog.sample.Transformer;
import by.topolev.network.data.csv.CSVFile;
import by.topolev.network.data.csv.CSVFileReader;
import by.topolev.network.data.csv.CSVFileReaderCreator;
import by.topolev.network.data.csv.CSVFileWriter;
import by.topolev.network.data.csv.FieldInTemplateClassNotFound;
import by.topolev.network.data.csv.InvalidCSVException;
import by.topolev.network.data.csv.TemplateNameClassNotFound;
import by.topolev.network.web.controller.CatalogData;

@Service
public class CatalogServiceImpl implements CatalogService {
	

	@Override
	public List<? extends CatalogDTO> loadCatalog(InputStream inputStream, String nameCatalogPOJO) throws InvalidCSVException{
		
		Class<? extends CatalogDTO> classEntity;
		try {
			classEntity = (Class<? extends CatalogDTO>) Class.forName(ConfigClass.DEFAULT_PACKAGE_CATALOG_POJO + "." + nameCatalogPOJO);
		} catch (ClassNotFoundException e) {
			throw new InvalidCSVException();
		}
		CSVFileReader<? extends CatalogDTO> fileReader = CSVFileReaderCreator.factory(classEntity);
		return fileReader.read(inputStream, ";");
	}

	@Override
	public String saveCatalogInCSV(CatalogData data) {
		Class<?> sampleEntity = null;
		CreatorCollectionEntity<? extends CatalogDTO> creator = null;

		try {
			sampleEntity = Class.forName(ConfigClass.DEFAULT_PACKAGE_CATALOG_POJO + '.' + data.getNameClass());
			if (sampleEntity == Transformer.class)
				creator = new CreatorCollectionEntity<Transformer>(Transformer.class, data);
			if (sampleEntity == OverheadLine.class)
				creator = new CreatorCollectionEntity<OverheadLine>(OverheadLine.class, data);
			if (sampleEntity == CableLine.class)
				creator = new CreatorCollectionEntity<CableLine>(CableLine.class, data);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return creator.getCSVFile();

	}

	public File getFileCatalogInCSV(CatalogData data) {
		String content = saveCatalogInCSV(data);
		String nameFile = getUniqNameFile(ConfigClass.DEFAULT_PATH_CSV_FILE, "csv");
		File file = new File(ConfigClass.DEFAULT_PATH_CSV_FILE + nameFile);
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

class CreatorCollectionEntity<T> {
	private List<T> collection = new ArrayList<T>();
	private CSVFileWriter<T> csvWriter = new CSVFileWriter<T>();

	public CreatorCollectionEntity(Class<T> clazz, CatalogData data) {
		for (Object row : data.getTable()) {
			Map<String, String> map = (Map<String, String>) row;
			ObjectMapper mapper = new ObjectMapper();
			collection.add((T) mapper.convertValue(map, clazz));
		}
	}

	public List<T> getCollection() {
		return collection;
	}

	public String getCSVFile() {
		return csvWriter.prepareCSVData(collection, ";");
	}
}
