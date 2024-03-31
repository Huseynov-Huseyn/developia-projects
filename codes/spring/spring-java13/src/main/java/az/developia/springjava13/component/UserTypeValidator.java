package az.developia.springjava13.component;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserTypeValidator implements ConstraintValidator<ValidationUserType, String> {

	@Override
	public boolean isValid(String userType, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		List<String> userTypes = Arrays.asList("student", "teacher", "Author");

		return userTypes.contains(userType);
	}

}
