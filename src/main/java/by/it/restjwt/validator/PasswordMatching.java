package by.it.restjwt.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static by.it.restjwt.utils.Constants.PASSWORD_NOT_MATCHING;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordMatchingValidator.class)
@Target(TYPE)
@Retention(RUNTIME)
public @interface PasswordMatching {
    String message() default PASSWORD_NOT_MATCHING;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
