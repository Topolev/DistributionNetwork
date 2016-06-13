package by.topolev.network.validatedata.field;

public interface ValidatorField<T> {
	void validate (T arg) throws NotValidException;
}
