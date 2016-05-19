package by.topolev.network.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.data.csv.InvalidCSVException;
import by.topolev.network.web.controller.CatalogData;

public interface CatalogService {
	
	public List<? extends CatalogDTO> loadCatalog(InputStream inputStream) throws InvalidCSVException;
	public List<? extends CatalogDTO> loadCatalog(InputStream inputStream, String nameClassEntity) throws InvalidCSVException;
	public String saveCatalogInCSV(CatalogData data) throws InvalidCSVException;
	public File getFileCatalogInCSV(CatalogData data) throws InvalidCSVException;;
}
