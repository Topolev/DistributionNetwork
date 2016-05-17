package by.topolev.network.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import by.topolev.network.data.catalog.sample.CableLine;
import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.data.catalog.sample.OverheadLine;
import by.topolev.network.data.catalog.sample.Transformer;
import by.topolev.network.data.csv.CSVFile;
import by.topolev.network.data.csv.CSVFileReader;
import by.topolev.network.data.csv.CSVFileReaderCreator;
import by.topolev.network.data.csv.FieldInTemplateClassNotFound;
import by.topolev.network.data.csv.TemplateNameClassNotFound;
import by.topolev.network.web.controller.CatalogData;

@Service
public class CatalogServiceImpl implements CatalogService {
	public static final String DEFAULT_PACKAGE_OF_ENTITY = "by.topolev.network.data.catalog.sample";

	@Override
	public Collection<? extends CatalogDTO> loadCatalog(InputStream inputStream) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		CSVFile csv = new CSVFile();
		try {
			String row = reader.readLine();
			csv.setHeaderFile(row);
			while ((row = reader.readLine()) != null) {
				csv.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		CSVFileReader<? extends CatalogDTO> csvFileReader = CSVFileReaderCreator.factory(csv.getClassEntity());
		Collection<? extends CatalogDTO> listEntity = null;
		try {
			listEntity = csvFileReader.read(csv);
		} catch (IllegalArgumentException | IllegalAccessException | TemplateNameClassNotFound
				| FieldInTemplateClassNotFound e) {
			e.printStackTrace();
		}
		return listEntity;

	}

	@Override
	public void saveCatalog(CatalogData data) {
		Class sampleEntity = null;
		CreatorCollectionEntity<? extends CatalogDTO> creator = null;
		
		try {
			sampleEntity = Class.forName(DEFAULT_PACKAGE_OF_ENTITY + '.' + data.getNameClass());
			if (sampleEntity == Transformer.class)
				creator = new CreatorCollectionEntity<Transformer>(Transformer.class,data);
			if (sampleEntity == OverheadLine.class)
				creator = new CreatorCollectionEntity<OverheadLine>(OverheadLine.class,data);
			if (sampleEntity == CableLine.class)
				creator = new CreatorCollectionEntity<CableLine>(CableLine.class,data);
			
			System.out.println("in try");
			for (Object element : creator.getCollection()){
				System.out.println(element);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	class CreatorCollectionEntity<T>{
		private Collection<T> collection;
		public CreatorCollectionEntity(Class<T> clazz, CatalogData data){
			for (Object row : data.getTable()) {
				Map<String, String> map = (Map<String, String>) row;
				ObjectMapper mapper = new ObjectMapper();
				collection.add((T) mapper.convertValue(map, clazz));
			}
		}
		public Collection<T> getCollection(){
			return collection;
		}
	}

}
