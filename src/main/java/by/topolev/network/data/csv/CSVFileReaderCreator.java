package by.topolev.network.data.csv;

import by.topolev.network.data.catalog.sample.CableLine;
import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.data.catalog.sample.OverheadLine;
import by.topolev.network.data.catalog.sample.Transformer;

public class CSVFileReaderCreator {
	public static CSVFileReader<? extends CatalogDTO> factory(Class entity){
		CSVFileReader<? extends CatalogDTO> result = null;
		if (entity == Transformer.class) return new CSVFileReader<Transformer>();
		if (entity == OverheadLine.class) return new CSVFileReader<OverheadLine>();
		if (entity == CableLine.class) return new CSVFileReader<CableLine>();
		return null;
	}
}
