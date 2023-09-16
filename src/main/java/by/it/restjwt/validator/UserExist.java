package by.it.restjwt.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static by.it.restjwt.utils.Constants.USER_EXIST;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UserExistValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface UserExist {
    String message() default USER_EXIST;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
