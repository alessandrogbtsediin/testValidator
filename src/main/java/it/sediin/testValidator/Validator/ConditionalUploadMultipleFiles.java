package it.sediin.testValidator.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Constraint(validatedBy = ConditionalUploadMultipleFilesValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConditionalUploadMultipleFiles {
    String message() default  "default error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
