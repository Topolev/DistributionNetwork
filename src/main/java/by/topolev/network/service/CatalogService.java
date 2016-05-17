package by.topolev.network.service;

import java.io.InputStream;
import java.util.Collection;

import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.web.controller.CatalogData;

public interface CatalogService {
	public Collection<? extends CatalogDTO>  loadCatalog(InputStream inputStream);
	public String saveCatalogInCSV(CatalogData data);
}
