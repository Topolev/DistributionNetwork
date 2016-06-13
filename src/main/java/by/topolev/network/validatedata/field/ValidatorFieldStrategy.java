package by.topolev.network.validatedata.field;

import java.util.List;

public interface ValidatorFieldStrategy {
	List<ValidatorField> find (String type) throws NotSupportTypeValidator;
}
