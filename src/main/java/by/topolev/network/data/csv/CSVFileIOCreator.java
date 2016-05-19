package by.topolev.network.data.csv;

import by.topolev.network.data.catalog.sample.CableLine;
import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.data.catalog.sample.OverheadLine;
import by.topolev.network.data.catalog.sample.Transformer;

public class CSVFileIOCreator {
	public static CSVFileIO<? extends CatalogDTO> factory(Class entity){
		CSVFileIO<? extends CatalogDTO> result = null;
		if (entity == Transformer.class) return new CSVFileIO<Transformer>();
		if (entity == OverheadLine.class) return new CSVFileIO<OverheadLine>();
		if (entity == CableLine.class) return new CSVFileIO<CableLine>();
		return null;
	}
}
