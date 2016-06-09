package by.topolev.network.api.signup;

public interface Validator<T> {
	void validate (T arg) throws NotValidException;
}
