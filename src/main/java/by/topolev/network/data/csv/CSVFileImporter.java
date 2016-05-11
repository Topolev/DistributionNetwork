package by.topolev.network.data.csv;

import java.util.Collection;

import by.topolev.network.data.catalog.sample.CatalogDTO;



public interface CSVFileImporter<DTO extends CatalogDTO> {
	Collection<DTO> importFile(CSVFile csfFile);
}
