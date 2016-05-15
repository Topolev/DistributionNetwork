package by.topolev.network.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import org.springframework.stereotype.Service;

import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.data.catalog.sample.Transformer;
import by.topolev.network.data.csv.CSVFile;
import by.topolev.network.data.csv.CSVFileReader;
import by.topolev.network.data.csv.CSVFileReaderCreator;
import by.topolev.network.data.csv.FieldInTemplateClassNotFound;
import by.topolev.network.data.csv.TemplateNameClassNotFound;

@Service
public class CatalogServiceImpl implements CatalogService{

	@Override
	public Collection<? extends CatalogDTO> loadCatalog(InputStream inputStream) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		CSVFile csv = new CSVFile();
		try {
			String row = reader.readLine();
			csv.setHeaderFile(row);
			while((row = reader.readLine())!=null){
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
	
}
