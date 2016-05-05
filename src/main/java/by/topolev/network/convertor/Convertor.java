package by.topolev.network.convertor;

/**
 * @author Vladimir
 *
 * @param <SOURCE>
 * @param <TARGET>
 */
public interface Convertor<SOURCE, TARGET> {
	/**
	 * Convert source object into target
	 * @param source
	 * @param target
	 */
	public void convert(SOURCE source, TARGET target);
}
