package az.developia.springjava13.component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
//runtime yoxsa class yeni ne zaman validation edeceyini sorusur
@Documented
@Constraint(validatedBy = UserTypeValidator.class)
public @interface ValidationUserType {
	public String message() default "Invalid UserType:It should be either Teacher or  Student or Author";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
