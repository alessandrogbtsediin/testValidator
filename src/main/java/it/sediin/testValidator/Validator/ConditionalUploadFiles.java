package it.sediin.testValidator.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Constraint(validatedBy = ConditionalUploadFilesValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConditionalUploadFiles {
    String message() default  "default error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
