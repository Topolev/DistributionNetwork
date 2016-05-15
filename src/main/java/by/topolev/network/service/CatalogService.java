package by.topolev.network.service;

import java.io.InputStream;
import java.util.Collection;

import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.data.catalog.sample.Transformer;

public interface CatalogService {
	public Collection<? extends CatalogDTO>  loadCatalog(InputStream inputStream);
}
