package by.topolev.network.data.catalog.service;

import java.util.Collection;

import by.topolev.network.data.catalog.sample.CatalogDTO;


public interface DTOPersistanceService<DTO extends CatalogDTO> {
	void persist(Collection<DTO> collection);
}
