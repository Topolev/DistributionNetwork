package by.topolev.network.convertor;

public interface Convertor<SOURCE, TARGET> {
	public TARGET convert(SOURCE source);
	public SOURCE reconvert(TARGET target);
}
